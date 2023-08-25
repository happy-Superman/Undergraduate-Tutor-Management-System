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
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);

        tableModel = new DefaultTableModel(new Object[]{"number","name","sex","研究方向","办公地址","联系方式","职称","已有学生数","最高学生数"}, 0);
        table = new JTable(tableModel);
        table.getColumnModel().getColumn(0).setCellEditor(new DefaultCellEditor(new JCheckBox()));
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); // 总是显示滚动条
        add(scrollPane, BorderLayout.CENTER);

        People people[] = db.founds("teacher","name!", "1" );  //name不等于1  爆出所有数据
        Teacher[] teacher = new Teacher[people.length];
        for(int i = 0; i < people.length; i++){
            teacher[i] = new Teacher();
            teacher[i] = (Teacher) people[i];
            if(teacher[i].getMax_studentNumber() > teacher[i].getNow_studentNumber()){
                //如果该老师未招满学生 则显示在列表中
                addTeacher(teacher[i]);
                sum ++;
            }

        }

        String[] options = new String[sum];
        int tmp = 0;  //填充options
        for(int i = 0; i < people.length; i++){
            teacher[i] = new Teacher();
            teacher[i] = (Teacher) people[i];
            if(teacher[i].getMax_studentNumber() > teacher[i].getNow_studentNumber()){
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

        //获取导师信息 在列表中显示




// 添加事件监听器

        //学号在登录时就有
        //正常选导师    在学生表中 根据学号查询state
        //学号在登录界面的文本框中获得


        //在下拉列表中获得信息  获得选中的老师姓名
        teacherBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedTeacher = (String) teacherBox.getSelectedItem();
            }
        });

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
        //冻结按钮
        else if(student.getState() == 2){
            comfirmButton.setEnabled(false);
        }

        //修改信息的按钮
        modifyButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                //进入修改学生个人信息的窗口
                new studentMessage(student);
            }
        });
    }

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
 */
//
//public class selectTutor {
//    String selectedTeacher;
//    JDBCaccess db;
//    int state;
//
//    public selectTutor(){
//        //关于数量问题 采用导入到界面列表时进行判断 如果学生数大于最大数 则不显示
//
////      学生确认选择某位老师的按钮
////        点击后把该学生的信息中选择导师改为对应老师的工号 这样老师查看的时候只查自己工号的学生
////        并且设置状态 冻结状态 无法选择其他老师
////        状态实现的方式时修改在数据库中的值
////        首先在数据库中该学生的状态中读取
////        如果state=2 则在此界面 但是无法点击确认按钮
////        如果老师选择了他 则把状态改成1  如果拒绝了则改为状态0
//        try {
//            db = new JDBCaccess();
////            accounts = db.getAllAccounts();
////            这里的db连接到数据库 然后调用里面的方法即可
//        }
//        catch(Exception e) {
//            e.printStackTrace();
//        }
//
//        //学号在登录时就有
//        //正常选导师    在学生表中 根据学号查询state
//        //学号在登录界面的文本框中获得
//        state = db.findState("Student",number);
//
//        //在下拉列表中获得信息  获得选中的老师姓名
//        teacherBox.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                selectedTeacher = (String) comboBox.getSelectedItem();
//            }
//        });
//
//        //状态0 正常进行导师选择
//        if(state == 0){
//            comfirmButton.setEnabled(true);
//            comfirmButton.addActionListener(new ActionListener(){
//                public void actionPerformed(ActionEvent e){
//                    teacherName = selectedTeacher;  //在前面的下拉列表中获得
//                    //根据老师的姓名获得老师的工号
//                    teacherNumber = db.findTeacherNumber(teacherName);
//                    //把学生的导师待选数据改为老师的工号
//                    db.changePendingTutor(studentNumber,teacherNumber);
//                    //把学生的状态设置为2 冻结确认按钮
//                    db.changeState(studentNumber,2);  //修改该同学的state为2 冻结按钮
//                    comfirmButton.setEnabled(false);
//                }
//            });
//        }
//        //冻结按钮
//        else if(state == 2){
//            comfirmButton.setEnabled(false);
//        }
//
//        //修改信息的按钮
//        changeButton.addActionListener(new ActionListener(){
//            public void actionPerformed(ActionEvent e){
//                   new studentMessage();
//            }
//        });
//
//
//    }
//}
//
//
//
