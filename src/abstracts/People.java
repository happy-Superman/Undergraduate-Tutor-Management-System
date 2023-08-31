package abstracts;

//��������ࡰ�ˡ���ģ��
public abstract class People
{
    //�û��Ĺ��š�ѧ��
    String numberString = null;
    //�û�������
    String password = null;
    //�û�������
    String name = null;
    public String getName()
    {
        return name;
    }

    public String getNumberString() {
        return numberString;
    }

    public String getPassword() {
        return password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNumberString(String numberString) {
        this.numberString = numberString;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    //���������Ϣ
    public abstract void out();
}