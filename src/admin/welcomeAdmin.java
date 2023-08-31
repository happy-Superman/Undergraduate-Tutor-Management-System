package admin;

import people.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class welcomeAdmin extends JFrame {
    private JButton modifyTeacherButton, modifyStudentButton, modifyTimeButton;

    public welcomeAdmin(Admin admin) {
        setTitle("管理员界面");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        JLabel welcomeLabel = new JLabel("欢迎您，管理员", JLabel.CENTER);
        add(welcomeLabel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));

        modifyTeacherButton = new JButton("修改教师信息");
        modifyStudentButton = new JButton("修改学生信息");
        modifyTimeButton = new JButton("修改系统开放时间");

        // 将按钮添加到垂直Box中
        buttonPanel.add(Box.createRigidArea(new Dimension(0, 20))); // 添加垂直间距
        buttonPanel.add(modifyTeacherButton);
        buttonPanel.add(Box.createRigidArea(new Dimension(0, 20))); // 添加垂直间距
        buttonPanel.add(modifyStudentButton);
        buttonPanel.add(Box.createRigidArea(new Dimension(0, 20))); // 添加垂直间距
        buttonPanel.add(modifyTimeButton);

        // 设置按钮居中对齐
        modifyTeacherButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        modifyStudentButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        modifyTimeButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        add(buttonPanel, BorderLayout.CENTER);

        modifyTeacherButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //添加或删除老师
                new modifyTeacher();
            }
        });

        modifyStudentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //添加或删除学生
                new modifyStudent();
            }
        });

        modifyTimeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //修改系统开放时间
                new modifyTime();
            }
        });
    }
}