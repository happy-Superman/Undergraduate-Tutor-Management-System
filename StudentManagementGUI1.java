package stduty;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class StudentManagementGUI1 {
    public static void main(String[] args) {
       new stu();
    }
}
class stu extends JFrame{
	private JLabel welcome=new JLabel("你好，同学");
	private JButton teacherMessage=new JButton("导师信息");
	private JButton notice=new JButton("通知");
	
	public stu() {
		super("学生界面");
		setLayout(null);
		setSize(400,300);
		setLocationRelativeTo(null);
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	setVisible(true);
    	
    	add(welcome);
    	add(teacherMessage);
    	add(notice);
    	teacherMessage.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new teacherMessage();
			}
    		
    	});
    	welcome.setBounds(168,0,110,55);
    	teacherMessage.setBounds(100,60,200,25);
    	notice.setBounds(100,120,200,25);
	}
}