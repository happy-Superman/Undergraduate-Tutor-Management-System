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
setTitle("ѧ������ϵͳ");
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setSize(800, 600);


String[] columnNames = {"number","name","sex","�о�����","�칫��ַ","��ϵ��ʽ","ְ��","����ѧ����","���ѧ����"};
String[][] data = {{" "," "," "," "," "," "," "," "," "}};
table = new JTable(data, columnNames);

JScrollPane scrollPane = new JScrollPane(table);
scrollPane.setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
scrollPane.setHorizontalScrollBarPolicy( JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);


String[] options = {"1","2","3","4"};
comboBox = new JComboBox<>(options);

comboBox.setPreferredSize(new Dimension(150, comboBox.getPreferredSize().height));

comfirmButton = new JButton("ȷ��");
modifyButton = new JButton("�޸�");

JPanel buttonPanel = new JPanel();
buttonPanel.add(comboBox);
buttonPanel.add(comfirmButton);
buttonPanel.add(modifyButton);


JPanel controlPanel = new JPanel();
controlPanel.setLayout(new BorderLayout());
controlPanel.add(buttonPanel, BorderLayout.NORTH);

// ����¼���������ʹ��Lambda���ʽ��
comfirmButton.addActionListener(e -> handleComfirmButtonClick());
modifyButton.addActionListener(e -> handleModifyButtonClick());

// �����Ϳ��������ӵ�������
add(scrollPane, BorderLayout.CENTER);
add(controlPanel, BorderLayout.SOUTH);

setVisible(true);
}

private void handleComfirmButtonClick() {
// ����ѡ�а�ť���߼�
}

private void handleModifyButtonClick() {
// �����޸İ�ť���߼�
}

public static void main(String[] args) {
	SwingUtilities.invokeLater(() -> new StudentManagementGUI2());
	}
}
