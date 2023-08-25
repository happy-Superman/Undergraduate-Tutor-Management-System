package teacher;

import AccessDatabase.JDBCaccess;
import abstracts.People;
import people.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class selectStudent extends JFrame {
    private JTable table;
    private DefaultTableModel tableModel;
    private JButton selectButton,rejectButton;
    private JButton modifyButton;

    //数据库用来查到学生
    JDBCaccess findStudentdb = new JDBCaccess();
    public selectStudent(Teacher teacher) {
        setTitle("选择学生");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setVisible(true);

        tableModel = new DefaultTableModel(new Object[]{"选择", "number", "name", "sex", "专业", "电话号码", "成绩"}, 0);
        table = new JTable(tableModel);
        table.getColumnModel().getColumn(0).setCellEditor(new DefaultCellEditor(new JCheckBox()));
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); // 总是显示滚动条
        add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        //把待选择的学生添加到列表

        People people[] = findStudentdb.founds("student","pendingTutor", teacher.getNumberString());
        Student[] student = new Student[people.length];
        for(int i = 0; i < people.length; i++){
            student[i] = new Student();
            student[i] = (Student)people[i];
            addStudent(student[i]);
        }

        //设置选择学生按钮
        selectButton = new JButton("选中");
        selectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StringBuilder selectedStudents = new StringBuilder("您选择的学生：\n");
                for (int i = 0; i < tableModel.getRowCount(); i++) {
                    Boolean isSelected = (Boolean) tableModel.getValueAt(i, 0);
                    if (isSelected != null && isSelected) {
                        String number = (String) tableModel.getValueAt(i,1);
                        //根据number去查找这个学生 然后修改他的状态 设置state为1 表示有导师
                        findStudentdb.updateInt("student",number,"state",1);
                        selectedStudents.append(number).append(" ");
                        String name = (String) tableModel.getValueAt(i,2);
                        selectedStudents.append(name).append("\n");
                    }
                }
                JOptionPane.showMessageDialog(selectStudent.this, selectedStudents.toString());

            }
        });
        buttonPanel.add(selectButton);

        //设置选择学生按钮
        rejectButton = new JButton("拒绝");
        rejectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StringBuilder selectedStudents = new StringBuilder("您拒绝的学生：\n");
                for (int i = 0; i < tableModel.getRowCount(); i++) {
                    Boolean isSelected = (Boolean) tableModel.getValueAt(i, 0);
                    if (isSelected != null && isSelected) {
                        String number = (String) tableModel.getValueAt(i,1);
                        //根据number去查找这个学生 然后修改他的状态 设置state为0 表示无导师
                        findStudentdb.updateInt("student",number,"state",0);
                        selectedStudents.append(number).append(" ");
                        String name = (String) tableModel.getValueAt(i,2);
                        selectedStudents.append(name).append("\n");
                    }
                }
                JOptionPane.showMessageDialog(selectStudent.this, selectedStudents.toString());
            }
        });
        buttonPanel.add(rejectButton);

        modifyButton = new JButton("修改信息");
        modifyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 在这里实现修改信息的逻辑
                new teacherMessage(teacher);
            }
        });
        buttonPanel.add(modifyButton);

        add(buttonPanel, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
    }

    public void addStudent(Student student) {
        tableModel.addRow(new Object[]{false, student.getNumberString(), student.getName(),student.getSex(), student.getSubject(), student.getPassword(), student.getScore()});
    }

}

//public class selectStudent {
//    /*
//     首先要在下拉列表框中获得学生姓名
//     然后对学生进行相应操作  比如选中获得是拒绝
//     如果是选中 把学生的状态设置 state设置为1 表示已有导师 对应工号不变 这样查看自己的学生时
//     就可以找学生中state为1 并且工号是自己的 即为自己的学生
//     如果拒绝 设置state为0
//     */
//    public String studentNumber;
//
//    public void selectStudent(){
//
//
//        mystudentButton.addActionListener(new ActionListener(){
//           public void actionPerformed(ActionEvent e){
//               //把数据库中学生状态是1 并且对应老师工号是自己的学生显示出来
////               没想出怎么写
//           }
//        });
//    }
//}
