package student;

import AccessDatabase.JDBCaccess;
import people.*;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

class myTeacher extends JFrame{
    private JLabel number=new JLabel("工号:");
    private JTextField numberField=new JTextField(20);
    private JLabel name=new JLabel("姓名：");
    private JTextField nameField=new JTextField(20);
    private JLabel sex=new JLabel("性别:");
    private JTextField sexField=new JTextField(20);
    private JLabel researchdir=new JLabel("研究方向:");
    private JTextField researchdirField=new JTextField(20);
    private JLabel address=new JLabel("办公地址:");
    private JTextField addressField=new JTextField(20);
    private JLabel contact=new JLabel("联系方式:");
    private JTextField contactField=new JTextField(20);
    private JLabel title=new JLabel("职称:");
    private JTextField titleField=new JTextField(20);
    private JTextArea noticeArea=new JTextArea();
    private JLabel notice=new JLabel("请及时查看通知");

    //需要根据目前学生的学号 提出这个学生的导师工号  然后用工号查找老师的信息
    Teacher teacher = new Teacher();

    JDBCaccess teacherdb = new JDBCaccess();
    public myTeacher(Student student) {
        super("我的导师");
        setLayout(null);
        setSize(430,400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        add(number);
        add(numberField);

        add(name);
        add(nameField);

        add(sex);
        add(sexField);

        add(researchdir);
        add(researchdirField);

        add(address);
        add(addressField);

        add(contact);
        add(contactField);

        add(title);
        add(titleField);

        add(noticeArea);
        add(notice);

        number.setBounds(50,30,100,25);
        numberField.setBounds(120,30,200,25);

        name.setBounds(50,60,100,25);
        nameField.setBounds(120,60,200,25);

        sex.setBounds(50,90,100,25);
        sexField.setBounds(120,90,200,25);

        researchdir.setBounds(50,120,100,25);
        researchdirField.setBounds(120,120,200,25);

        address.setBounds(50,150,100,25);
        addressField.setBounds(120,150,200,25);

        contact.setBounds(50,180,100,25);
        contactField.setBounds(120,180,200,25);

        title.setBounds(50,210,100,25);
        titleField.setBounds(120,210,200,25);

        noticeArea.setBounds(0,260,430,400);
        notice.setBounds(0,240,100,25);

        //查找我的导师数据库的信息 设置到文本框中显示  或者是你还没有导师
        teacher = (Teacher) teacherdb.found("teacher","number",student.getPendingTutor());
        numberField.setText(teacher.getNumberString());
        numberField.setEditable(false);

        nameField.setText(teacher.getName());
        nameField.setEditable(false);

        sexField.setText(teacher.getSex());
        sexField.setEditable(false);

        researchdirField.setText(teacher.getSubject());
        researchdirField.setEditable(false);

        addressField.setText(teacher.getAddress());
        addressField.setEditable(false);

        contactField.setText(teacher.getPhone());
        contactField.setEditable(false);

        titleField.setText(teacher.getProfessional());
        titleField.setEditable(false);

        noticeArea.setText(teacher.getMessageText());
        noticeArea.setEditable(false);

    }
}