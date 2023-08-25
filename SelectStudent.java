package stduty;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class SelectStudent extends JFrame {
    private JTable table;
    private DefaultTableModel tableModel;
    private JButton selectButton;
    private JButton rejectButton;
    private JButton modifyButton;

    public SelectStudent() {
        setTitle("选择学生");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());//创建窗口
        
        tableModel = new DefaultTableModel(new Object[]{"选择", "number", "name", "sex", "专业", "电话号码", "成绩"}, 0);//创建表格
        table = new JTable(tableModel);
        table.getColumnModel().getColumn(0).setCellEditor(new DefaultCellEditor(new JCheckBox()));//JTable的列中添加JCheckBox组件
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); // 总是显示滚动条
        add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        selectButton = new JButton("选中");//选择按钮
        rejectButton = new JButton("拒绝");//拒绝按钮
        selectButton.addActionListener(new ActionListener() {//添加选择按钮的点击事件
            @Override
            public void actionPerformed(ActionEvent e) { // 获取选中的行
                StringBuilder selectedStudents = new StringBuilder("您选择的学生：\n");
                for (int i = 0; i < tableModel.getRowCount(); i++) {
                    Boolean isSelected = (Boolean) tableModel.getValueAt(i, 0);
                    if (isSelected != null && isSelected) {// 处理选中的行
                        String number = (String) tableModel.getValueAt(i,1);
                        selectedStudents.append(number).append(" ");
                        String name = (String) tableModel.getValueAt(i,2);
                        selectedStudents.append(name).append("\n");
                    }
                }
                JOptionPane.showMessageDialog(SelectStudent.this, selectedStudents.toString());
            }
        });
        buttonPanel.add(selectButton);
        
        rejectButton.addActionListener(new ActionListener() {//添加拒绝按钮的点击事件
            @Override
            public void actionPerformed(ActionEvent e) {
                StringBuilder selectedStudents = new StringBuilder("您拒绝的学生：\n");
                for (int i = 0; i < tableModel.getRowCount(); i++) {
                    Boolean isSelected = (Boolean) tableModel.getValueAt(i, 0);
                    if (isSelected != null && isSelected) {
                        String number = (String) tableModel.getValueAt(i,1);
                        selectedStudents.append(number).append(" ");
                        String name = (String) tableModel.getValueAt(i,2);
                        selectedStudents.append(name).append("\n");
                    }
                }
                JOptionPane.showMessageDialog(SelectStudent.this, selectedStudents.toString());
            }
        });
        buttonPanel.add(rejectButton);

        modifyButton = new JButton("修改信息");
        modifyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 在这里实现修改信息的逻辑
                JOptionPane.showMessageDialog(SelectStudent.this, "这个张汉卿你自己加功能吧，组长赛高");
            }
        });
        buttonPanel.add(modifyButton);//添加修改信息按钮的点击事件

        add(buttonPanel, BorderLayout.SOUTH);//以上按钮布局在窗口最下面

        pack();
        setLocationRelativeTo(null);
    }

        public void addStudent(String number, String name, String sex, String major, String tel, String score) {
        tableModel.addRow(new Object[]{false, number, name, sex, major, tel, score});
    }

    public static void main(String[] args) {
    	 SwingUtilities.invokeLater(new Runnable() {
             @Override
             public void run() {
                 SelectStudent ui = new SelectStudent();
                 ui.addStudent("22111306012", "张汉卿","男","网络空间安全","191xxxx6748","99");
                 ui.addStudent("22111306042", "王光正","男","网络空间安全","191xxxx6748","99");
                 ui.addStudent("22111306023", "储千荟","女","网络空间安全","191xxxx6748","99");
                 ui.addStudent("22111306047", "何羽童","女","网络空间安全","191xxxx6748","99");
                 ui.setVisible(true);
             }
         });
     }
}
