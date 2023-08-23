package jdbc;

import java.sql.*;
import abstracts.People;
import people.Student;
import people.Teacher;

public class JDBCaccess 
{
	Connection con;
	Statement sql;
	ResultSet rs;
	
	
	public JDBCaccess()
	{
		try{
			Class.forName("com.hxtt.sql.access.AccessDriver");
			con = DriverManager.getConnection("jdbc:Access:///sql\\Manager.accdb");
		}catch(Exception ee) {
			ee.printStackTrace();
		}
		if(con != null)
			System.out.println("���ݿ����ӳɹ���");
		else
			System.out.println("���ݿ�����ʧ�ܣ�");	
	}
	
	
	
	public People found(String type,String message,String contect)
	{
		try 
		{
			sql = con.createStatement();
			rs = sql.executeQuery("select * from " + type + " where " +message +"='" +contect+"'");
			if(type.equals("teacher"))
			{
				Teacher teacher = null;
				while(rs.next())
				{
					teacher = new Teacher();
					teacher.setNumberString(rs.getString("number"));
					teacher.setPassword(rs.getString("password"));
					teacher.setName(rs.getString("name"));
					teacher.setSex(rs.getString("sex"));
					teacher.setSubject(rs.getString("�о�����"));
					teacher.setPhone(rs.getString("��ϵ��ʽ"));
					teacher.setAddress(rs.getString("�칫��ַ"));
					teacher.setProfessional(rs.getString("ְ��"));
					teacher.setNow_studentNumber(rs.getInt("����ѧ������"));
					teacher.setMax_studentNumber(rs.getInt("���ѧ������"));
				}
				return teacher;
			}
			else
			{
				Student student = null;
				while(rs.next())
				{
					student = new Student();
					student.setName(rs.getString("name"));
					student.setNumberString(rs.getString("number"));
					student.setPassword(rs.getString("password"));
					student.setSex(rs.getString("sex"));
					student.setScore(rs.getInt("�ɼ�"));
					student.setPhone(rs.getString("����"));
					student.setSubject(rs.getString("רҵ"));
					student.setState(rs.getInt("state"));
					student.setPendingTutor(rs.getString("pendingTutor"));
					student.setExperience(rs.getString("�񽱾���"));		
				}
				return student;
			}
		} catch (Exception e) {
			System.out.print("select * from " + type + " where " +message +"='" +contect+"'");
		}
		return null;
	}
	
	
	
	public People[] founds(String type,String message,String contect)
	{
		try 
		{
			sql = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
			rs = sql.executeQuery("select * from " + type + " where " +message +"='" +contect+"'");
			rs.last();
			int max = rs.getRow();
			if(type.equals("teacher"))
			{
				Teacher teacher[] = new Teacher[max];
				
				for(int i=0;i<max;i++)
				{
					rs.absolute(i+1);
					teacher[i] = new Teacher();
					teacher[i].setNumberString(rs.getString("number"));
					teacher[i].setPassword(rs.getString("password"));
					teacher[i].setName(rs.getString("name"));
					teacher[i].setSex(rs.getString("sex"));
					teacher[i].setSubject(rs.getString("�о�����"));
					teacher[i].setPhone(rs.getString("��ϵ��ʽ"));
					teacher[i].setAddress(rs.getString("�칫��ַ"));
					teacher[i].setProfessional(rs.getString("ְ��"));
					teacher[i].setNow_studentNumber(rs.getInt("����ѧ������"));
					teacher[i].setMax_studentNumber(rs.getInt("���ѧ������"));
				}
				return teacher;
			}
			else
			{
				Student student[] = new Student[max];
				for(int i=0;i<max;i++)
				{
					rs.absolute(i+1);
					student[i] = new Student();
					student[i].setName(rs.getString("name"));
					student[i].setNumberString(rs.getString("number"));
					student[i].setPassword(rs.getString("password"));
					student[i].setSex(rs.getString("sex"));
					student[i].setScore(rs.getInt("�ɼ�"));
					student[i].setPhone(rs.getString("����"));
					student[i].setSubject(rs.getString("רҵ"));
					student[i].setState(rs.getInt("state"));
					student[i].setPendingTutor(rs.getString("pendingTutor"));
					student[i].setExperience(rs.getString("�񽱾���"));		
				}
				return student;
			}
		} catch (Exception e) {
			System.out.print("select * from " + type + " where " +message +"='" +contect+"'");
		}
		return null;
	}
	
	
	public void update(String type,String number,String message,String contect)
	{
		try {
			sql = con.createStatement();
			String sqlstr = null;
				sqlstr = "update " + type +" set "+ message + " ='" +contect 
						+ "' where number="+number;
				int ok = sql.executeUpdate(sqlstr);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	public void delect(String number)
	{
		try {
			sql = con.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
			String sqlstr = "delect from " + (number.length()==7?"teacher":"student") 
					+ " where number="+number;
	}
}
