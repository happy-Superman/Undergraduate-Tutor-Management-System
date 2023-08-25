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
        setTitle("ѡ��ѧ��");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());//��������
        
        tableModel = new DefaultTableModel(new Object[]{"ѡ��", "number", "name", "sex", "רҵ", "�绰����", "�ɼ�"}, 0);//�������
        table = new JTable(tableModel);
        table.getColumnModel().getColumn(0).setCellEditor(new DefaultCellEditor(new JCheckBox()));//JTable���������JCheckBox���
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); // ������ʾ������
        add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        selectButton = new JButton("ѡ��");//ѡ��ť
        rejectButton = new JButton("�ܾ�");//�ܾ���ť
        selectButton.addActionListener(new ActionListener() {//���ѡ��ť�ĵ���¼�
            @Override
            public void actionPerformed(ActionEvent e) { // ��ȡѡ�е���
                StringBuilder selectedStudents = new StringBuilder("��ѡ���ѧ����\n");
                for (int i = 0; i < tableModel.getRowCount(); i++) {
                    Boolean isSelected = (Boolean) tableModel.getValueAt(i, 0);
                    if (isSelected != null && isSelected) {// ����ѡ�е���
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
        
        rejectButton.addActionListener(new ActionListener() {//��Ӿܾ���ť�ĵ���¼�
            @Override
            public void actionPerformed(ActionEvent e) {
                StringBuilder selectedStudents = new StringBuilder("���ܾ���ѧ����\n");
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

        modifyButton = new JButton("�޸���Ϣ");
        modifyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // ������ʵ���޸���Ϣ���߼�
                JOptionPane.showMessageDialog(SelectStudent.this, "����ź������Լ��ӹ��ܰɣ��鳤����");
            }
        });
        buttonPanel.add(modifyButton);//����޸���Ϣ��ť�ĵ���¼�

        add(buttonPanel, BorderLayout.SOUTH);//���ϰ�ť�����ڴ���������

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
                 ui.addStudent("22111306012", "�ź���","��","����ռ䰲ȫ","191xxxx6748","99");
                 ui.addStudent("22111306042", "������","��","����ռ䰲ȫ","191xxxx6748","99");
                 ui.addStudent("22111306023", "��ǧ��","Ů","����ռ䰲ȫ","191xxxx6748","99");
                 ui.addStudent("22111306047", "����ͯ","Ů","����ռ䰲ȫ","191xxxx6748","99");
                 ui.setVisible(true);
             }
         });
     }
}
