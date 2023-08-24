package laoshi;

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
    private JButton modifyButton;

    public SelectStudent() {
        setTitle("选择学生");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        tableModel = new DefaultTableModel(new Object[]{"选择", "number", "name", "sex", "专业", "电话号码", "成绩"}, 0);
        table = new JTable(tableModel);
        table.getColumnModel().getColumn(0).setCellEditor(new DefaultCellEditor(new JCheckBox()));
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); // 总是显示滚动条
        add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        selectButton = new JButton("选中");
        selectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StringBuilder selectedStudents = new StringBuilder("您选择的学生：\n");
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
        buttonPanel.add(selectButton);

        modifyButton = new JButton("修改信息");
        modifyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 在这里实现修改信息的逻辑
                JOptionPane.showMessageDialog(SelectStudent.this, "点击了修改信息按钮");
            }
        });
        buttonPanel.add(modifyButton);

        add(buttonPanel, BorderLayout.SOUTH);

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
                 ui.addStudent("22111306x", "张汉卿","男","网络空间安全","191xxxx6748","99");
                 ui.addStudent("22111306x", "王光正","男","网络空间安全","191xxxx6748","99");
                 ui.addStudent("22111306x", "储千荟","女","网络空间安全","191xxxx6748","99");
                 ui.addStudent("22111306x", "何羽童","女","网络空间安全","191xxxx6748","99");
                 ui.setVisible(true);
             }
         });
     }
}
