package student;
//内部类型引用
import people.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class welcomeStudent extends JFrame{
        private JLabel welcome=new JLabel("你好，同学");
        private JButton selectTeacher=new JButton("选择导师");
        private JButton myTeacher=new JButton("我的导师");

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
                    //把这个学生的全部状态作为参数 传入到选择导师的界面 主要利用state状态
                    new selectTutor(student);
                }

            });
            myTeacher.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    // TODO Auto-generated method stub
                    //进入自己的导师界面
                    new myTeacher(student);
                }

            });

            welcome.setBounds(168,0,110,55);
            selectTeacher.setBounds(100,60,200,25);
            myTeacher.setBounds(100,120,200,25);
        }
}

