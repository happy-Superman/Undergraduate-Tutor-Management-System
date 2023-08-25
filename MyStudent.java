package laoshi;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyStudent extends JFrame {
	private JTable table;
	private JTextField textField;
	private JButton publishButton;

	public MyStudent() {
		setTitle("�ҵ�ѧ��");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 600);

		String[] columnNames = { "number", "name", "sex", "רҵ", "����", "�ɼ�" };
		String a = "wan";
		String[][] data = { { a, " ", " ", " ", " ", " " }, { " ", " ", " ", " ", " ", " ", " " },
				{ " ", " ", " ", " ", " ", " ", " " }, { " ", " ", " ", " ", " ", " ", " " },
				{ " ", " ", " ", " ", " ", " ", " " }, { " ", " ", " ", " ", " ", " ", " " },
				{ " ", " ", " ", " ", " ", " ", " " }, { " ", " ", " ", " ", " ", " ", " " },
				{ " ", " ", " ", " ", " ", " ", " " }, { " ", " ", " ", " ", " ", " ", " " },
				{ " ", " ", " ", " ", " ", " ", " " }, { " ", " ", " ", " ", " ", " ", " " },
				{ " ", " ", " ", " ", " ", " ", " " }, { " ", " ", " ", " ", " ", " ", " " },
				{ " ", " ", " ", " ", " ", " ", " " }, { " ", " ", " ", " ", " ", " ", " " },
				{ " ", " ", " ", " ", " ", " ", " " }, { " ", " ", " ", " ", " ", " ", " " },
				{ " ", " ", " ", " ", " ", " ", " " }, { " ", " ", " ", " ", " ", " ", " " },
				{ " ", " ", " ", " ", " ", " ", " " }, { " ", " ", " ", " ", " ", " ", " " },
				{ " ", " ", " ", " ", " ", " ", " " }, { " ", " ", " ", " ", " ", " ", " " },
				{ " ", " ", " ", " ", " ", " ", " " }, { " ", " ", " ", " ", " ", " ", " " },
				{ " ", " ", " ", " ", " ", " ", " " }, { " ", " ", " ", " ", " ", " ", " " },
				{ " ", " ", " ", " ", " ", " ", " " }, { " ", " ", " ", " ", " ", " ", " " },
				{ " ", " ", " ", " ", " ", " ", " " }, { " ", " ", " ", " ", " ", " ", " " },
				{ " ", " ", " ", " ", " ", " ", " " }, { " ", " ", " ", " ", " ", " ", " " },
				{ " ", " ", " ", " ", " ", " ", " " }, { " ", " ", " ", " ", " ", " ", " " },
				{ " ", " ", " ", " ", " ", " ", " " }, { " ", " ", " ", " ", " ", " ", " " },
				{ " ", " ", " ", " ", " ", " ", " " }, { " ", " ", " ", " ", " ", " ", " " },
				{ " ", " ", " ", " ", " ", " ", " " }, { " ", " ", " ", " ", " ", " ", " " },
				{ " ", " ", " ", " ", " ", " ", " " }, { " ", " ", " ", " ", " ", " ", " " },
				{ " ", " ", " ", " ", " ", " ", " " }, { " ", " ", " ", " ", " ", " ", " " },
				{ " ", " ", " ", " ", " ", " ", " " }, { " ", " ", " ", " ", " ", " ", " " },
				{ " ", " ", " ", " ", " ", " ", " " }, { " ", " ", " ", " ", " ", " ", " " },
				{ " ", " ", " ", " ", " ", " ", " " }, { " ", " ", " ", " ", " ", " ", " " } };
		table = new JTable(data, columnNames);

		JScrollPane tableScrollPane = new JScrollPane(table);
		tableScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		tableScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

		textField = new JTextField(20);
		publishButton = new JButton("����");

		JPanel inputPanel = new JPanel();
		inputPanel.add(textField);
		inputPanel.add(publishButton);

		JPanel controlPanel = new JPanel();
		controlPanel.setLayout(new BorderLayout());
		controlPanel.add(inputPanel, BorderLayout.SOUTH);

		add(tableScrollPane, BorderLayout.CENTER);
		add(controlPanel, BorderLayout.SOUTH);

		setVisible(true);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> new MyStudent());
	}
}