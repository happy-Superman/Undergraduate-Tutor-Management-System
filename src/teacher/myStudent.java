package teacher;
import AccessDatabase.JDBCaccess;
import abstracts.People;
import people.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class myStudent extends JFrame {
    private JTable table;
    private JTextField textField;
    private JButton publishButton;
    private DefaultTableModel tableModel;

    JDBCaccess myStudentdb = new JDBCaccess();
    public myStudent(Teacher teacher) {
        setTitle("我的学生");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(800, 600);

        //创建列表 存放我的学生信息
        tableModel = new DefaultTableModel(new Object[]{ "number", "name", "sex", "专业", "号码", "成绩" }, 0);
        table = new JTable(tableModel);
        table.getColumnModel().getColumn(0).setCellEditor(new DefaultCellEditor(new JCheckBox()));
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); // 总是显示滚动条

        People people[] = myStudentdb.founds("student","pendingTutor", teacher.getNumberString());
        Student[] student = new Student[people.length];
        for(int i = 0; i < people.length; i++){
            student[i] = new Student();
            student[i] = (Student)people[i];
            if(student[i].getState() == 1){
                addMyStudent(student[i]);
            }
        }

        //设置发布通知按钮
        textField = new JTextField(20);
        publishButton = new JButton("发布");

        publishButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //把通知写入到老师的数据库中
                myStudentdb.update("teacher", teacher.getNumberString(), "通知",textField.getText());
                //弹出发布成功窗口
                JOptionPane.showMessageDialog(null,"发布成功！");
            }
        });
        JPanel inputPanel = new JPanel();
        inputPanel.add(textField);
        inputPanel.add(publishButton);

        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new BorderLayout());
        controlPanel.add(inputPanel, BorderLayout.SOUTH);

        add(scrollPane, BorderLayout.CENTER);
        add(controlPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void addMyStudent(Student student) {
        tableModel.addRow(new Object[]{student.getNumberString(), student.getName(),student.getSex(), student.getSubject(), student.getPhone(), student.getScore()});
    }
}