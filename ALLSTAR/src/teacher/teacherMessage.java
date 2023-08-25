package teacher;

import AccessDatabase.JDBCaccess;
import people.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class teacherMessage extends JFrame {
    private JLabel name = new JLabel("姓名：");
    private JTextField nameField = new JTextField(20);
    private JLabel number = new JLabel("工号：");
    private JTextField numberField = new JTextField(20);
    private JLabel major = new JLabel("研究方向：");
    private JTextField majorField = new JTextField(20);
    private JLabel password = new JLabel("修改密码：");
    private JTextField passwordField = new JTextField(20);
    private JLabel phone = new JLabel("修改电话：");
    private JTextField phoneField = new JTextField(20);
    private JLabel score = new JLabel("修改职称：");
    private JTextField scoreField = new JTextField(20);
    private JLabel office = new JLabel("修改办公地点：");
    private JTextField officeField = new JTextField(20);

    private JButton confirmButton = new JButton("确认修改");

    //连接数据库 更新数据
    JDBCaccess teacherdb = new JDBCaccess();


    public teacherMessage(Teacher teacher) {
        super("修改导师信息");
        setLayout(null);
        setSize(400, 370);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        add(name);
        add(nameField);

        add(number);
        add(numberField);
        add(major);
        add(majorField);
        add(password);
        add(passwordField);
        add(phone);
        add(phoneField);
        add(score);
        add(scoreField);
        add(office);
        add(officeField);

        add(confirmButton);

        //还需要在数据库中读取到下列的初始信息
        //然后在文本框设置初始值


        name.setBounds(50, 0, 100, 25);
        nameField.setBounds(120, 0, 200, 25);

        number.setBounds(50, 30, 100, 25);
        numberField.setBounds(120, 30, 200, 25);


        major.setBounds(50, 60, 100, 25);
        majorField.setBounds(120, 60, 200, 25);


        password.setBounds(50, 90, 100, 25);
        passwordField.setBounds(120, 90, 200, 25);


        phone.setBounds(50, 120, 100, 25);
        phoneField.setBounds(120, 120, 200, 25);


        score.setBounds(50, 150, 100, 25);
        scoreField.setBounds(120, 150, 200, 25);


        office.setBounds(50, 180, 100, 25);
        officeField.setBounds(120, 180, 200, 25);

        confirmButton.setBounds(100, 210, 100, 25);

        nameField.setText(teacher.getName());
        nameField.setEditable(false); // 设置文本框不可编辑
        numberField.setText(teacher.getNumberString());
        numberField.setEditable(false); // 设置文本框不可编辑
        majorField.setText(teacher.getSubject());
        majorField.setEditable(false); // 设置文本框不可编辑


        passwordField.setText(teacher.getPassword());
        phoneField.setText(teacher.getPhone());
        scoreField.setText(teacher.getProfessional());
        officeField.setText(teacher.getAddress());

        confirmButton.addActionListener(new ActionListener() {


            @Override
            public void actionPerformed(ActionEvent e) {

                //提取文本框的内容 修改到数据库中
                //如果密码不同 则对数据库进行修改
                String newPassword = passwordField.getText();
                String newPhone = phoneField.getText();
                String newScore = phoneField.getText();
                String newOffice = officeField.getText();
                if (!newPassword.equals(teacher.getPassword())) {
                    teacherdb.update("student", teacher.getNumberString(), "password",newPassword);
                }
                if (!newPhone.equals(teacher.getPhone())) {
                    teacherdb.update("student", teacher.getNumberString(), "联系电话",newPhone);
                }
                if (!newScore.equals(teacher.getProfessional())) {
                    teacherdb.update("student", teacher.getNumberString(), "职称",newScore);
                }
                if (!newOffice.equals(teacher.getAddress())) {
                    teacherdb.update("student", teacher.getNumberString(), "办公地址",newOffice);
                }


            }
        });
    }
}