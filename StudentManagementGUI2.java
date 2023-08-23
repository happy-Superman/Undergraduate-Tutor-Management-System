package stduty;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentManagementGUI2 extends JFrame {
private JTable table;
private JComboBox<String> comboBox;
private JButton comfirmButton;
private JButton modifyButton;
private JTextField textField;


public StudentManagementGUI2() {
setTitle("学生管理系统");
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setSize(800, 600);


String[] columnNames = {"number","name","sex","研究方向","办公地址","联系方式","职称","已有学生数","最高学生数"};
String[][] data = {{" "," "," "," "," "," "," "," "," "}};
table = new JTable(data, columnNames);

JScrollPane scrollPane = new JScrollPane(table);
scrollPane.setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
scrollPane.setHorizontalScrollBarPolicy( JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);


String[] options = {"1","2","3","4"};
comboBox = new JComboBox<>(options);

comboBox.setPreferredSize(new Dimension(150, comboBox.getPreferredSize().height));

comfirmButton = new JButton("确定");
modifyButton = new JButton("修改");

JPanel buttonPanel = new JPanel();
buttonPanel.add(comboBox);
buttonPanel.add(comfirmButton);
buttonPanel.add(modifyButton);


JPanel controlPanel = new JPanel();
controlPanel.setLayout(new BorderLayout());
controlPanel.add(buttonPanel, BorderLayout.NORTH);

// 添加事件监听器（使用Lambda表达式）
comfirmButton.addActionListener(e -> handleComfirmButtonClick());
modifyButton.addActionListener(e -> handleModifyButtonClick());

// 将表格和控制面板添加到主界面
add(scrollPane, BorderLayout.CENTER);
add(controlPanel, BorderLayout.SOUTH);

setVisible(true);
}

private void handleComfirmButtonClick() {
// 处理选中按钮的逻辑
}

private void handleModifyButtonClick() {
// 处理修改按钮的逻辑
}

public static void main(String[] args) {
	SwingUtilities.invokeLater(() -> new StudentManagementGUI2());
	}
}
