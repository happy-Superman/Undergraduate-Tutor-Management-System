package Main;
//内部引用
import student.welcomeStudent;
import teacher.welcomeTeacher;
import admin.welcomeAdmin;
import people.*;

import java.awt.*;
import java.time.*;

import AccessDatabase.JDBCaccess;
import abstracts.People;
import people.Student;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Login extends JFrame
{
    //登录标签，无用时可作废
    JLabel tip = new JLabel("登录界面");

    //定义账号与密码的标签
    JLabel accountLabel = new JLabel("账号");
    JLabel passwordLabel = new JLabel("密码");

    //定义账号和密码的文本框
    JTextField accountField = new JTextField();
    JPasswordField passwordField = new JPasswordField();

    //定义单选按钮以及按钮群
    JRadioButton adminButton = new JRadioButton("管理员");
    JRadioButton teacherButton = new JRadioButton("教师");
    JRadioButton studentButton = new JRadioButton("学生");
    ButtonGroup users = new ButtonGroup();

    //定义登录按钮
    JButton loginButton = new JButton("登录");

    JDBCaccess db = new JDBCaccess();

    //身份类型
    String type;

    //设置people  包含number password name
    People people = new People() {
        @Override
        public void out() {}
    };


    Student student = new Student();
    Teacher teacher = new Teacher();
    Admin admin = new Admin();

    public Login()
    {
        super("本科生-导师管理系统");

        //位置初始化
        init();
        //设置监听器
        listenMethod();

        //对窗口进行基本设置
        this.setBounds(300, 250, 350, 210);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    void init()
    {
        //将按钮合并为一个按钮群
        users.add(studentButton);
        users.add(teacherButton);
        users.add(adminButton);


        //定义盒子容器，以便布局
        Box accountBox = Box.createHorizontalBox();
        Box passwordBox  = Box.createHorizontalBox();
        Box textBox = Box.createVerticalBox();
        Box userBox = Box.createHorizontalBox();
        Box down = Box.createHorizontalBox();


        //将“账户”的标签文本框加入盒中
        accountBox.add(Box.createHorizontalStrut(50));
        accountBox.add(accountLabel);
        accountBox.add(Box.createHorizontalStrut(10));
        accountBox.add(accountField);
        accountBox.add(Box.createHorizontalStrut(80));

        //将“密码”的标签文本框加入盒中
        passwordBox.add(Box.createHorizontalStrut(50));
        passwordBox.add(passwordLabel);
        passwordBox.add(Box.createHorizontalStrut(10));
        passwordBox.add(passwordField);
        passwordBox.add(Box.createHorizontalStrut(80));

        userBox.add(studentButton);
        userBox.add(teacherButton);
        userBox.add(adminButton);

        textBox.add(Box.createVerticalStrut(20));
        textBox.add(accountBox);
        textBox.add(Box.createVerticalStrut(20));
        textBox.add(passwordBox);
        textBox.add(Box.createVerticalStrut(10));
        textBox.add(userBox);

        down.add(Box.createHorizontalStrut(130));
        down.add(loginButton, BorderLayout.CENTER);
        down.add(Box.createHorizontalStrut(100));

        this.add(textBox, BorderLayout.CENTER);
        this.add(down, BorderLayout.SOUTH);

        //添加图片
        // 1.创建一个ImageIcon对象，即背景图片。
        ImageIcon bg = new ImageIcon("picture\\login.jpg");

        // 2.创建一个JLabel对象，并将ImageIcon对象作为参数传递给它。
        JLabel label = new JLabel(bg);

        label.setBounds(0,0,600,400);

        // 3.将JLabel的大小设置为与图片大小相同。
        label.setSize(bg.getIconWidth(), bg.getIconHeight());

        this.getLayeredPane().add(label,Integer.valueOf(Integer.MIN_VALUE));
//        this.add(label);
//        this.getContentPane().add(label,new Integer(Integer.MIN_VALUE));
        ((JPanel)this.getContentPane()).setOpaque(false);

    }
    public void listenMethod(){
        /*
        获得按钮的选项 赋值给type
         */
        //设置选择按钮的监听
        studentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                type = studentButton.getText();
            }
        });
        //设置选择按钮的监听
        teacherButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                type = teacherButton.getText();
            }
        });
        //设置选择按钮的监听
        adminButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                type = adminButton.getText();
            }
        });
        /*
        对登录按钮进行操作
         */
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /*
                输错之后重新获得一个people对象
                 */
                people = new People() {
                    @Override
                    public void out() {}
                };

                //进行登录验证 根据学号 获得密码 与现在输入的进行匹配
                people.setNumberString(accountField.getText());
                //在数据库中获得某个学号的全部信息
                if (type.equals("教师")){
                        people = db.found("teacher", "number", people.getNumberString());
                        /*
                        如果没找到 则表示账号不存在
                         */
                        if(people == null){
                            accountField.setText(null);
                            passwordField.setText(null);
                        }
                }
                else if(type.equals("学生")){
                    people = db.found("student","number",people.getNumberString());
                    /*
                        如果没找到 则表示账号不存在
                         */
                    if(people == null){
                        accountField.setText(null);
                        passwordField.setText(null);
                    }
                }
                else if(type.equals("管理员")){
                    people = db.found("admin","number",people.getNumberString());
                    /*
                        如果没找到 则表示账号不存在
                         */
                    if(people == null){
                        accountField.setText(null);
                        passwordField.setText(null);
                    }
                }
                /*
                登录成功的标准 用户存在并且密码正确
                 */
                if(people != null) {
                    if (passwordField.getText().equals(people.getPassword())) {
                        //登录成功 根据身份进入到不同的界面
                        if (type.equals("教师")) {
                            teacher = (Teacher) db.found("teacher", "number", accountField.getText());
                            /*
                            首先对系统开放的时间进行验证
                             */
                            Time time = new Time();
                            if (time.getNowDate().compareTo(time.getBeginDate()) < 0) {
                                JOptionPane.showMessageDialog(null, "系统还未开放", "错误", JOptionPane.ERROR_MESSAGE);
                            } else if (time.getNowDate().compareTo(time.getEndDate()) > 0) {
                                JOptionPane.showMessageDialog(null, "系统已经结束", "错误", JOptionPane.ERROR_MESSAGE);
                            } else {
                                new welcomeTeacher(teacher);
                            }
                        } else if (type.equals("学生")) {
                            student = (Student) db.found("student", "number", accountField.getText());
                            /*
                            首先对系统开放的时间进行验证
                             */
                            Time time = new Time();
                            if (time.getNowDate().compareTo(time.getBeginDate()) < 0) {
                                JOptionPane.showMessageDialog(null, "系统还未开放", "错误", JOptionPane.ERROR_MESSAGE);
                            } else if (time.getNowDate().compareTo(time.getEndDate()) > 0) {
                                JOptionPane.showMessageDialog(null, "系统已经结束", "错误", JOptionPane.ERROR_MESSAGE);
                            } else {
                                new welcomeStudent(student);
                            }
                        } else if (type.equals("管理员")) {
                            admin = (Admin) db.found("admin", "number", accountField.getText());
                            new welcomeAdmin(admin);
                        }
                    }
                    else{
                        //登录失败 弹出提示
                        JOptionPane.showMessageDialog(null,"账号或密码错误","错误",JOptionPane.ERROR_MESSAGE);
                    }
                }
                else{
                    //登录失败 弹出提示
                    JOptionPane.showMessageDialog(null,"账号或密码错误","错误",JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

}

