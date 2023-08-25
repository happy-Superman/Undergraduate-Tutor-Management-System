package teacher;

import people.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class welcomeTeacher extends JFrame {
    private JButton selectStudent, myStudent;

    public welcomeTeacher(Teacher teacher) {
        setTitle("导师界面");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        JLabel welcomeLabel = new JLabel("欢迎您，老师", JLabel.CENTER);
        add(welcomeLabel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));

        selectStudent = new JButton("选择学生");
        myStudent = new JButton("我的学生");

        // 将按钮添加到垂直Box中
        buttonPanel.add(Box.createRigidArea(new Dimension(0, 20))); // 添加垂直间距
        buttonPanel.add(selectStudent);
        buttonPanel.add(Box.createRigidArea(new Dimension(0, 20))); // 添加垂直间距
        buttonPanel.add(myStudent);
        buttonPanel.add(Box.createRigidArea(new Dimension(0, 20))); // 添加垂直间距

        // 设置按钮居中对齐
        selectStudent.setAlignmentX(Component.CENTER_ALIGNMENT);
        myStudent.setAlignmentX(Component.CENTER_ALIGNMENT);

        add(buttonPanel, BorderLayout.CENTER);

        selectStudent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new selectStudent(teacher);
            }
        });

        myStudent.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new myStudent(teacher);
            }
        });
    }


}

