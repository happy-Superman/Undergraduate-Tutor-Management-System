package people;

import java.io.*;
import java.lang.reflect.Field;
import java.security.PublicKey;
import java.time.LocalDate;
import java.util.Set;

public class Time extends Thread
{
	//��ʼ���ڣ���������ʱֱ�Ӵ��ļ���ȡ��
	LocalDate beginDate;
	//��������������ʱֱ�Ӵ��ļ���ȡ��
	LocalDate endDate;
	//�������ڵ�ʱ�䣨ȡ����ϵͳʱ�䣩
	LocalDate nowDate;
	
	
	public Time() 
	{
		nowDate = LocalDate.now();
		this.start();
		
		File file = new File("date\\beginDate.txt");
		if(!file.exists())
		{
			System.out.print("����");	
		}
		else 
		{
			Reader inReader = null;
			try {
				inReader = new FileReader(file);
				BufferedReader read = new BufferedReader(inReader);
				String str = null;
				str = read.readLine();
				int year = Integer.parseInt(str);
				str = read.readLine();
				int month = Integer.parseInt(str);
				str = read.readLine();
				int day = Integer.parseInt(str);
				beginDate = LocalDate.of(year, month, day);
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		file = new File("date\\endDate.txt");
		if(!file.exists())
		{
			System.out.print("����");	
		}
		else 
		{
			Reader inReader = null;
			try {
				inReader = new FileReader(file);
				BufferedReader read = new BufferedReader(inReader);
				String str = null;
				str = read.readLine();
				int year = Integer.parseInt(str);
				str = read.readLine();
				int month = Integer.parseInt(str);
				str = read.readLine();
				int day = Integer.parseInt(str);
				endDate = LocalDate.of(year, month, day);
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
	//��local��������ʱ��
	public void setBeginDate(LocalDate date)
	{
		int year = date.getYear();
		int month = date.getMonthValue();
		int day = date.getDayOfMonth();
		setBeginDate( year, month,day);
	}
	
	
	//������������ʱ��
	public void setBeginDate(int year,int month,int day)
	{
		beginDate = LocalDate.of(year, month, day);
		File file = new File("date\\beginDate.txt");
		
		//�ļ����������������
		if(!file.exists())
		{
			System.out.print("����");	
		}
		else 
		{
			Writer toFileReader = null;
			try {
				toFileReader = new FileWriter(file);
				BufferedWriter outBufferedWriter = new BufferedWriter(toFileReader);
				
				//���ж�ȡ��1��2��3�зֱ���������
				outBufferedWriter.write(year+"");
				outBufferedWriter.newLine();
				outBufferedWriter.write(month+"");
				outBufferedWriter.newLine();
				outBufferedWriter.write(day+"");
				outBufferedWriter.newLine();
				outBufferedWriter.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
	//��local�������ý���ʱ��
	public void setEndDate(LocalDate date)
	{
		int year = date.getYear();
		int month = date.getMonthValue();
		int day = date.getDayOfMonth();
		setEndDate( year, month,day);
	}
	
	//�����������ý���ʱ��
	public void setEndDate(int year,int month,int day)
	{
		endDate = LocalDate.of(year, month, day);
		File file = new File("date\\endDate.txt");
		if(!file.exists())
		{
			System.out.print("����");	
		}
		else 
		{
			Writer toFileReader = null;
			try {
				toFileReader = new FileWriter(file);
				BufferedWriter outBufferedWriter = new BufferedWriter(toFileReader);
				
				//����д�룬1��2��3�зֱ���������
				outBufferedWriter.write(year+"");
				outBufferedWriter.newLine();
				outBufferedWriter.write(month+"");
				outBufferedWriter.newLine();
				outBufferedWriter.write(day+"");
				outBufferedWriter.newLine();
				outBufferedWriter.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
	//��ÿ�ʼʱ��
	public LocalDate getBeginDate() {
		return beginDate;
	}
	
	//��ý���ʱ��
	public LocalDate getEndDate() {
		return endDate;
	}
	
	//��ý���ʱ��
	public LocalDate getNowDate() {
		return nowDate;
	}
	
	//�̣߳��ڶ��󴴽�ʱ��ʼ�����ϸ��µ�ǰʱ��
	public void run()
	{
		while(true)
		{
			nowDate = LocalDate.now();
		}
	}
}
