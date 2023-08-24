package stduty;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class myTeacher {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new noTeacher();
	}
}
	class noTeacher extends JFrame{
		
		
		public noTeacher() {
			JOptionPane.showMessageDialog(null, "你还没有导师！", "我的导师",JOptionPane.INFORMATION_MESSAGE);
		}
		

		
	}

