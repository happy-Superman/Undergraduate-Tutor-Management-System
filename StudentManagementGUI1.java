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
	private JButton selectTeacher=new JButton("选择导师");
	private JButton myTeacher=new JButton("我的导师");
	
	public stu() {
		super("学生界面");
		setLayout(null);
		setSize(400,300);
		setLocationRelativeTo(null);
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	setVisible(true);
    	
    	add(welcome);
    	add(selectTeacher);
    	add(myTeacher);

    	selectTeacher.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new StudentManagementGUI2();
			}
    		
    	});
    	myTeacher.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new teacherMessage();
			}
    		
    	});
         
    	welcome.setBounds(168,0,110,55);
    	selectTeacher.setBounds(100,60,200,25);
    	myTeacher.setBounds(100,120,200,25);
	}
}