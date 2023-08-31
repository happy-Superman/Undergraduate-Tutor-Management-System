package student;
//内部类型引用
import AccessDatabase.JDBCaccess;
import abstracts.People;
import people.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class welcomeStudent extends JFrame{
        private JLabel welcome=new JLabel("你好，同学");
        private JButton selectTeacher=new JButton("选择导师");
        private JButton myTeacher=new JButton("我的导师");
        JDBCaccess db = new JDBCaccess();

        public welcomeStudent(Student student) {
            super("学生界面");
            setLayout(null);
            setSize(400,300);
            setLocationRelativeTo(null);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setVisible(true);

            add(welcome);
            add(selectTeacher);
            add(myTeacher);

            selectTeacher.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    // TODO Auto-generated method stub
                    if(student.getState()==1){
                        JOptionPane.showMessageDialog(null,"你已经被导师录取！");
                    }
                    //把这个学生的全部状态作为参数 传入到选择导师的界面 主要利用state状态
                    else if(student.getState()==2){
                        StringBuilder state_2 = new StringBuilder("你已经选择导师：");
                        String number = student.getPendingTutor();
                        //根据工号获得导师姓名
                        People getTeacherName = db.found("teacher","number",number);
                        String name = getTeacherName.getName();
                        state_2.append(name).append("(").append(number).append(") ").append("请耐心等待结果...");
                        JOptionPane.showMessageDialog(null,state_2.toString());
                    }
                    else{
                        new selectTutor(student);
                    }
                }

            });
            myTeacher.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // TODO Auto-generated method stub
                    //进入自己的导师界面
                    if(student.getState()==1){
                        new myTeacher(student);
                    }
                    else if(student.getState()==0){
                        JOptionPane.showMessageDialog(null,"你还未选择导师");
                    }
                    else if(student.getState()==2){
                        StringBuilder state_2 = new StringBuilder("你已经选择导师：");
                        String number = student.getPendingTutor();
                        //根据工号获得导师姓名
                        People getTeacherName = db.found("teacher","number",number);
                        String name = getTeacherName.getName();
                        state_2.append(name).append("(").append(number).append(") ").append("请耐心等待结果...");
                        JOptionPane.showMessageDialog(null,state_2.toString());
                    }
                }
            });

            welcome.setBounds(168,0,110,55);
            selectTeacher.setBounds(100,60,200,25);
            myTeacher.setBounds(100,120,200,25);
        }
}

