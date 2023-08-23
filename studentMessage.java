package student;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class B{
    public static void main(String[] a){
        new studentMessage();
    }
}
public class studentMessage extends JFrame {

//    public static void main(String[] args) {
//        //数据库读取学生是否有导师状态
//
//        string name = A.findStudentState();
//        int haveTutor;
//        haveTutor = 0;
//        //如果有进入一种界面
//        if(haveTutor == 1){
//            new myTutor();
//        }
////      如果没有进入导师选择界面
//        else{
//            new selectTutor();
//        }
//    }
    private JLabel name = new JLabel("姓名：");
    private JTextField nameField = new JTextField(20);
    private JLabel number = new JLabel("学号：");
    private JTextField numberField = new JTextField(20);
    private JLabel major = new JLabel("专业：");
    private JTextField majorField = new JTextField(20);
    private JLabel password = new JLabel("修改密码：");
    private JTextField passwordField = new JTextField(20);
    private JLabel phone = new JLabel("修改电话：");
    private JTextField phoneField = new JTextField(20);
    private JLabel score = new JLabel("修改成绩：");
    private JTextField scoreField = new JTextField(20);
    private JLabel honor = new JLabel("获奖荣誉：");
    private JTextField honorField = new JTextField(20);

    private JButton confirmButton = new JButton("确认修改");
    private String names;

    public studentMessage(){
        super("修改学生信息");
        setLayout(null);
        setSize(400,370);
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
        add(honor);
        add(honorField);

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


        honor.setBounds(50, 180, 100, 25);
        honorField.setBounds(120, 180, 200, 25);

        confirmButton.setBounds(100, 210, 100, 25);

        Student student = new Student();
        nameField.setText(student.name);
        nameField.setEditable(false); // 设置文本框不可编辑
        numberField.setText(student.number);
        numberField.setEditable(false); // 设置文本框不可编辑
        majorField.setText(student.major);
        majorField.setEditable(false); // 设置文本框不可编辑


        passwordField.setText(student.password);
        phoneField.setText(student.password);
        scoreField.setText(student.score);
        honorField.setText(student.honor);

        confirmButton.addActionListener(new ActionListener() {


            @Override
            public void actionPerformed(ActionEvent e) {

                //提取文本框的内容 修改到数据库中
                //如果密码不同 则对数据库进行修改
                String newPassword = passwordField.getText();
                String newPhone = phoneField.getText();
                String newScore = phoneField.getText();
                String newHonor = honorField.getText();
                if(!newPassword.equals(student.password)){
                    db.changePassword();
                }
                if(!newPhone.equals(student.phone)){
                    db.changePhone();
                }
                if(!newScore.equals(student.score)){
                    db.changeScore();
                }
                if(!newHonor.equals(student.honor)){
                    db.changeHonor();
                }


            }
        });
    }
}