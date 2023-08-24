package people;

import abstracts.People;
import abstracts.TS;

public class Teacher extends TS
{
	//��ʦ�İ칫��ַ
	String address = null;
	//��ʦ��ְ��
	String professional = null;
	//��ʦ������ѧ����
	int now_studentNumber = 0;
	//��ʦ����ӵ�е�ѧ�������ɸ��ģ�
	int max_studentNumber = 10;
	//��ʦ�����Ĺ���
	String messageText = null;
	public Teacher(){}
	
	public Teacher(String numberString,String password,String name ,String sex ,String subject,String phone ,
	String address,String professional,int now_studentNumber,int max_studentNumber ,String messageText)
	{
		super.setName(name);
		super.setNumberString(numberString);
		super.setPassword(password);
		super.setPhone(phone);
		super.setSex(sex);
		super.setSubject(subject);
		setAddress(address);
		setProfessional(professional);
		setNow_studentNumber(now_studentNumber) ;
		setMax_studentNumber(max_studentNumber);
		setMessageText(messageText);
	}
	
	public String getAddress() {
		return address;
	}
	
	public String getProfessional() {
		return professional;
	}
	
	public int getNow_studentNumber() {
		return now_studentNumber;
	}
	
	public int getMax_studentNumber() {
		return max_studentNumber;
	}
	
	public String getMessageText() {
		return messageText;
	}
	
	public void setNow_studentNumber(int now_studentNumber) {
		this.now_studentNumber = now_studentNumber;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public void setProfessional(String professional) {
		this.professional = professional;
	}
	
	public void setMax_studentNumber(int max_studentNumber) {
		this.max_studentNumber = max_studentNumber;
	}
	
	public void setMessageText(String messageText) {
		this.messageText = messageText;
	}
	
	public void out()
	{
		System.out.println(getNumberString()+"\n"+getPassword()+"\n"+getName()+"\n"+getSex()+"\n"+getSubject()+"\n"+getPhone()+"\n"+
 address+"\n"+professional+"\n"+now_studentNumber+"\n"+max_studentNumber+"\n"+messageText);
	}
}
