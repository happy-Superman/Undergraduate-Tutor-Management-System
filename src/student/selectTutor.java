package student;

import abstracts.People;
import people.*;

import AccessDatabase.JDBCaccess;

import java.awt.event.ActionEvent;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class selectTutor extends JFrame {
    private JTable table;
    private JComboBox<String> teacherBox;
    private JButton comfirmButton;
    private JButton modifyButton;
    private JTextField textField;

    //用工号选择导师
    String selectedTeacher;
    JDBCaccess db = new JDBCaccess();

    private DefaultTableModel tableModel;

    //设置合适老师的数量
    int sum = 0;


    public selectTutor(Student student) {
        setTitle("学生管理系统");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(800, 600);


        //获取导师信息 在列表中显示
        tableModel = new DefaultTableModel(new Object[]{"number","name","sex","研究方向","办公地址","联系方式","职称","已申请学生数","最高学生数"}, 0);
        table = new JTable(tableModel);
        //下面这一句是第一个可以点击为ture
//        table.getColumnModel().getColumn(0).setCellEditor(new DefaultCellEditor(new JCheckBox()));
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); // 总是显示滚动条
        add(scrollPane, BorderLayout.CENTER);

        People people[] = db.founds("teacher","name!", "1" );  //name不等于1  爆出所有数据
        Teacher[] teacher = new Teacher[people.length];

        //类似上面的people列表 我们获得一个学生的全部数据
        People stuNow[] = db.founds("student","name!", "1" );  //name不等于1  爆出所有数据
        Student[] students = new Student[stuNow.length];
        for(int i = 0; i < people.length; i++){
            teacher[i] = new Teacher();
            teacher[i] = (Teacher) people[i];
            //这个地方有问题 因为在数据库中少写了一列 存放老师招收的人数 所以这位老师通过的学生数量我们可以根据数据库读取
            int now_student = 0;
            for(int j = 0; j < stuNow.length; j++){
                students[j] = new Student();
                students[j] = (Student) stuNow[j];
                if(students[j].getPendingTutor().equals(teacher[i].getNumberString()) && students[j].getState() == 1){
                    now_student++;
                }
            }
            if(teacher[i].getMax_studentNumber() > now_student){
                //如果该老师未招满学生 则显示在列表中
                addTeacher(teacher[i]);
                sum ++;
            }
        }
        //因为数组的大小未知 所以想跑一遍上面的代码 同时记录数量
        /*
        将老师工号添加到选择列表框中
         */
        String[] options = new String[sum];
        int tmp = 0;  //填充options
        for(int i = 0; i < people.length; i++){
            teacher[i] = new Teacher();
            teacher[i] = (Teacher) people[i];
            //这个地方有问题 因为在数据库中少写了一列 存放老师招收的人数 所以这位老师通过的学生数量我们可以根据数据库读取
            int now_student = 0;
            for(int j = 0; j < stuNow.length; j++){
                if(students[j].getPendingTutor().equals(teacher[i].getNumberString()) && students[j].getState() == 1){
                    now_student++;
                }
            }
            if(teacher[i].getMax_studentNumber() > now_student){
                //如果该老师未招满学生 则显示在列表中
                options[tmp] = teacher[i].getNumberString();
                tmp++;
            }

        }

        teacherBox = new JComboBox<>(options);
        teacherBox.setPreferredSize(new Dimension(150, teacherBox.getPreferredSize().height));

        comfirmButton = new JButton("确定");
        modifyButton = new JButton("修改个人信息");

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(teacherBox);
        buttonPanel.add(comfirmButton);
        buttonPanel.add(modifyButton);


        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new BorderLayout());
        controlPanel.add(buttonPanel, BorderLayout.NORTH);


        // 将表格和控制面板添加到主界面
        add(scrollPane, BorderLayout.CENTER);
        add(controlPanel, BorderLayout.SOUTH);

        setVisible(true);

        //在下拉列表中获得信息  获得选中的老师姓名
        teacherBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedTeacher = (String) teacherBox.getSelectedItem();
            }
        });
        /*
        学生状态为0 表示可以正常选择导师
         */
        if(student.getState() == 0){
            comfirmButton.setEnabled(true);
            comfirmButton.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    //把学生的导师待选数据改为老师的工号
                    student.setPendingTutor(selectedTeacher);
                    db.update("student",student.getNumberString(),"pendingTutor",selectedTeacher);
                    //把学生的状态设置为2 冻结确认按钮
                    db.updateInt("student",student.getNumberString(),"state",2);  //修改该同学的state为2 冻结按钮
                    //还需要修改对于导师的已有学生数量
                    Teacher myTeacher = new Teacher();
                    myTeacher = (Teacher) db.found("teacher","number",selectedTeacher);
                    db.updateInt("teacher",selectedTeacher,"已有学生数量",myTeacher.getNow_studentNumber()+1);
                    comfirmButton.setEnabled(false);
                }
            });
        }
        /*
        状态表示已经选择导师 但是对应导师还在审核中
        原本是直接设置确认按钮冻结
        现在打算修改为提示信息
        你已经选择导师：姓名（工号) 请耐心等待结果...
         */
        else if(student.getState() == 2){
            comfirmButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    StringBuilder state_2 = new StringBuilder("你已经选择导师：");
                    String number = student.getPendingTutor();
                    //根据工号获得导师姓名
                    People getTeacherName = db.found("teacher","number",number);
                    String name = getTeacherName.getName();
                    state_2.append(name).append("(").append(number).append(") ").append("请耐心等待结果...");
                    JOptionPane.showMessageDialog(null,state_2.toString());
                }
            });
        }

        //修改信息的按钮
        modifyButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                //进入修改学生个人信息的窗口
                new studentMessage(student);
            }
        });
    }

    /*
    将老师的信息添加到界面的列表中的方法
     */
    public void addTeacher(Teacher teacher){
        tableModel.addRow(new Object[]{teacher.getNumberString(), teacher.getName(),teacher.getSex(), teacher.getSubject(),
                teacher.getAddress(),teacher.getPhone(),teacher.getProfessional(),teacher.getNow_studentNumber(),teacher.getMax_studentNumber()});
    }

}

/*
state 0 进入选择导师
        ， 1 have
        ， 2 选择界面 点击过确认键 老师正在审核 这个确认按钮冻结
pendingTutor  导师的工号


        关于数量问题 采用导入到界面列表时进行判断 如果学生数大于最大数 则不显示
        学生确认选择某位老师的按钮
        点击后把该学生的信息中选择导师改为对应老师的工号 这样老师查看的时候只查自己工号的学生
        并且设置状态 冻结状态 无法选择其他老师
        状态实现的方式时修改在数据库中的值
        首先在数据库中该学生的状态中读取
        如果state=2 则在此界面 但是无法点击确认按钮
        如果老师选择了他 则把状态改成1  如果拒绝了则改为状态0


        学号在登录时就有
        正常选导师    在学生表中 根据学号查询state
        学号在登录界面的文本框中获得
*/
