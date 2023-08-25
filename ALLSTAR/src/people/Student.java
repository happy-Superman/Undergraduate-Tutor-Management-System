package people;

import abstracts.People;
import abstracts.TS;

public class Student extends TS
{
    //ѧ���ĳɼ�
    int score;
    //ѧ����״̬��Ϊ0���ʾ�޵�ʦ��Ϊ1����ʦ����У�Ϊ2�������е�ʦ
    int state;
    //�е�ʦʱ���ţ���ʾ��ʦ�Ĺ���
    String pendingTutor;
    //�񽱾������ɲ���
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
    public int getScore() {
        // TODO Auto-generated method stub
        return score;
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

    @Override
    public void out() {

    }
//    public void out()
//    {
//        System.out.println(getNumberString()+"\n"+getPassword()+"\n"+getName()+"\n"+getSex()+"\n"+getSubject()+"\n"+getPhone()+"\n"+
//                score+"\n"+ state+"\n"+pendingTutor+"\n"+experience);
//    }
}
