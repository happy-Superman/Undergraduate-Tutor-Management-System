package people;

import abstracts.People;
import abstracts.TS;

public class Student extends TS
{
	//学生的成绩
	int score;
	//学生的状态：为0则表示无导师，为1代表导师审核中，为2代表已有导师
	int state;
	//有导师时开放，表示导师的工号
	String pendingTutor;
	//获奖经历，可不填
	String experience;
	
	public Student() {
		// TODO Auto-generated constructor stub
	}
	public Student(String numberString,String password,String name ,String sex ,String subject,String phone,
			int score,int state,String pendingTutor,String experience) {
		super.setName(name);
		super.setNumberString(numberString);
		super.setPassword(password);
		super.setPhone(phone);
		super.setSex(sex);
		super.setSubject(subject);
		setScore(score);
		setState(state);
		setPendingTutor(pendingTutor);
		setExperience(experience);
	}
	public int getState() {
		return state;
	}
	public String getSex() {
		// TODO Auto-generated method stub
		return super.getSex();
	}
	public String getPendingTutor() {
		return pendingTutor;
	}
	public String getExperience() {
		return experience;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public void setState(int state) {
		this.state = state;
	}
	public void setPendingTutor(String pendingTutor) {
		this.pendingTutor = pendingTutor;
	}
	public void setExperience(String experience) {
		this.experience = experience;
	}
	public void out()
	{
		System.out.println(getNumberString()+"\n"+getPassword()+"\n"+getName()+"\n"+getSex()+"\n"+getSubject()+"\n"+getPhone()+"\n"+
				score+"\n"+ state+"\n"+pendingTutor+"\n"+experience);
	}
}
