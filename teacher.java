package stduty;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class teacher {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new teacherMessage();
	}
}
class teacherMessage extends JFrame{
	private JLabel number=new JLabel("����:");
	private JTextField numberField=new JTextField(20);
	private JLabel name=new JLabel("������");
    private JTextField nameField=new JTextField(20);
    private JLabel sex=new JLabel("�Ա�:");
    private JTextField sexField=new JTextField(20);
    private JLabel researchdir=new JLabel("�о�����:");
    private JTextField researchdirField=new JTextField(20);
    private JLabel address=new JLabel("�칫��ַ:");
    private JTextField addressField=new JTextField(20);
    private JLabel contact=new JLabel("��ϵ��ʽ:");
    private JTextField contactField=new JTextField(20);
    private JLabel title=new JLabel("ְ��:");
    private JTextField titleField=new JTextField(20);
    
    public teacherMessage() {
    	super("��ʦ��Ϣ");
    	setLayout(null);
    	setSize(400,370);
    	setLocationRelativeTo(null);
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	setVisible(true);
    	
    	add(number);
    	add(numberField);
    	
    	add(name);
    	add(nameField);
    	
    	add(sex);
    	add(sexField);
    	
    	add(researchdir);
    	add(researchdirField);
    	
    	add(address);
    	add(addressField);
    	
    	add(contact);
    	add(contactField);
    	
    	add(title);
    	add(titleField);
    	
    	number.setBounds(50,30,100,25);
    	numberField.setBounds(120,30,200,25);
    	
    	name.setBounds(50,60,100,25);
    	nameField.setBounds(120,60,200,25);
    	
    	sex.setBounds(50,90,100,25);
    	sexField.setBounds(120,90,200,25);
    	
    	researchdir.setBounds(50,120,100,25);
    	researchdirField.setBounds(120,120,200,25);
    	
    	address.setBounds(50,150,100,25);
    	addressField.setBounds(120,150,200,25);
    	
    	contact.setBounds(50,180,100,25);
    	contactField.setBounds(120,180,200,25);
    	
        title.setBounds(50,210,100,25);
    	titleField.setBounds(120,210,200,25);
    }
}
