package abstracts;

public abstract class TS extends People
{
    //�û����Ա�
    String sex = null;
    //�û���רҵ
    String subject = null;
    //�û��ĵ绰��ϵ��ʽ
    String phone = null;
    public String getPhone() {
        return phone;
    }

    public String getSex() {
        return sex;
    }

    public String getSubject() {
        return subject;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
