package stduty;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class notice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new nNotice();
	}
}
	class nNotice extends JFrame{
		private JTextArea a=new JTextArea();
		private JLabel b=new JLabel("请及时查看通知");
				
		public nNotice() {
			super("通知");
			setLayout(null);
	    	setSize(400,300);
	    	setLocationRelativeTo(null);
	    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    	setVisible(true);
	    	add(a);
	    	add(b);
	    	a.setBounds(0,30,400,280);
	    	b.setBounds(0,1,100,25);
		}
	}

