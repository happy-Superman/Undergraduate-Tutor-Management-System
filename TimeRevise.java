package login;

import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.time.LocalDate;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import people.Time;

public class TimeRevise extends JFrame
{
	//��ʼʱ���ǩ
	JLabel beginTime = new JLabel("��ʼʱ��");
	//����ʱ���ǩ
	JLabel endTime = new JLabel("����ʱ��");
	//��ʼ�����յ������б�
	JComboBox beginYear = new JComboBox();
	JComboBox beginMonth = new JComboBox();
	JComboBox beginDay = new JComboBox();
	//���������յ������б�
	JComboBox endYear = new JComboBox();
	JComboBox endMonth = new JComboBox();
	JComboBox endDay = new JComboBox();
	//�޸İ�ť
	JButton revise = new JButton("�޸�");
	//ʱ������ԭ��ʼ����ʱ��
	Time time = new Time();
	
	
	public TimeRevise()
	{
		super("�޸�ϵͳ����ʱ��");
		setFrame();
		Item();
		setTime(time.getBeginDate(),time.getEndDate());
		TimeListener timeListener = new TimeListener();
		beginYear.addItemListener(timeListener);
		beginMonth.addItemListener(timeListener);
		beginDay.addItemListener(timeListener);
		endYear.addItemListener(timeListener);
		endMonth.addItemListener(timeListener);
		endDay.addItemListener(timeListener);
		revise.addActionListener(timeListener);
		this.setBounds(450, 250, 400, 250);
		this.setVisible(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	
	//���ַ�ʽ
	void setFrame()
	{
		Box beginBox = Box.createHorizontalBox();
		Box endBox = Box.createHorizontalBox();
		Box reviseBox  = Box.createHorizontalBox();
		Box box = Box.createVerticalBox();
		
		
		beginBox.add(Box.createHorizontalStrut(40));
		beginBox.add(beginTime);beginBox.add(Box.createHorizontalStrut(10));
		beginBox.add(beginYear);beginBox.add(new Label("��"));
		beginBox.add(beginMonth);beginBox.add(new Label("��"));
		beginBox.add(beginDay);beginBox.add(new Label("��"));

		endBox.add(Box.createHorizontalStrut(40));
		endBox.add(endTime);endBox.add(Box.createHorizontalStrut(10));
		endBox.add(endYear);endBox.add(new Label("��"));
		endBox.add(endMonth);endBox.add(new Label("��"));
		endBox.add(endDay);endBox.add(new Label("��"));
		
		reviseBox.add(revise);
		
		box.add(Box.createVerticalStrut(30));
		box.add(beginBox);box.add(Box.createVerticalStrut(40));
		box.add(endBox);box.add(Box.createVerticalStrut(50));
		box.add(reviseBox);
		box.add(Box.createVerticalStrut(40));
		
		add(box);
	}
	
	//��������б��е�ѡ����
	void Item()
	{
		for(int i = 2023; i <= 2050 ;i++)
		{
			beginYear.addItem(i+"");
		}
		for(int i = 1; i <= 12 ;i++)
		{
			beginMonth.addItem(i+"");
		}
		for(int i = 2023; i <= 2050 ;i++)
		{
			endYear .addItem(i+"");
		}
		for(int i = 1; i <= 12 ;i++)
		{
			endMonth.addItem(i+"");
		}
	}
	
	//���ݵ�ǰ���·��޸�����ѡ���������
	void set_day(LocalDate localdate,boolean e)
	{
		if(e)
		{
			beginDay.removeAllItems();
			for(int i=1;i<= localdate.lengthOfMonth();i++)
				beginDay.addItem(i+"");
		}
			
		else 
		{
			endDay.removeAllItems();
			for(int i=1;i<= localdate.lengthOfMonth();i++)
				endDay.addItem(i+"");
		}
			
	}
	
	//���������local���������б�ĵ�ǰѡ������ڽ����������ʾ��ʼ��
	void setTime(LocalDate localdate0,LocalDate localdate1)
	{
		beginYear.setSelectedItem(localdate0.getYear()+"");
		beginMonth.setSelectedItem(localdate0.getMonthValue()+"");
		set_day(localdate0,true);
		beginDay.setSelectedItem(localdate0.getDayOfMonth()+"");
		
		
		endYear.setSelectedItem(localdate1.getYear()+"");
		endMonth.setSelectedItem(localdate1.getMonthValue()+"");
		set_day(localdate1,false);
		endDay.setSelectedItem(localdate1.getDayOfMonth()+"");
	}
	
	
	
	class TimeListener implements ActionListener,ItemListener
	{
		LocalDate date0,date1;
		public void itemStateChanged(ItemEvent e)
		{
			if(e.getSource() == beginYear)
			{
				int year = Integer.parseInt(beginYear.getSelectedItem().toString());
				int month = Integer.parseInt(beginMonth.getSelectedItem().toString());
				date0 = LocalDate.of(year, month, 1);
				set_day(date0, true);
			}
			if(e.getSource() == beginMonth)
			{
				int year = Integer.parseInt(beginYear.getSelectedItem().toString());
				int month = Integer.parseInt(beginMonth.getSelectedItem().toString());
				date0 = LocalDate.of(year, month, 1);
				set_day(date0, true);
			}
			if(e.getSource() == beginDay && e.getStateChange()==ItemEvent.SELECTED)
			{
				int year = Integer.parseInt(beginYear.getSelectedItem().toString());
				int month = Integer.parseInt(beginMonth.getSelectedItem().toString());
				int day = Integer.parseInt(beginDay.getSelectedItem().toString());
				date0 = LocalDate.of(year, month, day);
			}
			if(e.getSource() == endYear)
			{
				int year = Integer.parseInt(endYear.getSelectedItem().toString());
				int month = Integer.parseInt(endMonth.getSelectedItem().toString());
				date1 = LocalDate.of(year, month, 1);
				set_day(date1, false);
			}
			if(e.getSource() == endMonth)
			{
				int year = Integer.parseInt(endYear.getSelectedItem().toString());
				int month = Integer.parseInt(endMonth.getSelectedItem().toString());
				date1 = LocalDate.of(year, month, 1);
				set_day(date1, false);
			}
			if(e.getSource() == endDay && e.getStateChange()==ItemEvent.SELECTED)
			{
				int year = Integer.parseInt(endYear.getSelectedItem().toString());
				int month = Integer.parseInt(endMonth.getSelectedItem().toString());
				int day = Integer.parseInt(endDay.getSelectedItem().toString());
				date1 = LocalDate.of(year, month, day);
			}
			
			System.out.println(date0+"\n"+date1);
		}

		@Override
		public void actionPerformed(ActionEvent e) 
		{
			// TODO Auto-generated method stub
			if(e.getSource() == revise)
			{
				int year = Integer.parseInt(beginYear.getSelectedItem().toString());
				int month = Integer.parseInt(beginMonth.getSelectedItem().toString());
				int day = Integer.parseInt(beginDay.getSelectedItem().toString());
				date0 = LocalDate.of(year, month, day);
				

				year = Integer.parseInt(endYear.getSelectedItem().toString());
				month = Integer.parseInt(endMonth.getSelectedItem().toString());
				day = Integer.parseInt(endDay.getSelectedItem().toString());
				date1 = LocalDate.of(year, month, day);
				
				if(date1.compareTo(date0) > 0)
				{
					time.setBeginDate(date0);
					
					time.setEndDate(date1);
					
					JOptionPane.showMessageDialog(null,"�޸ĳɹ�","��Ϣ",JOptionPane.INFORMATION_MESSAGE);
				}
				else
				{
					JOptionPane.showMessageDialog(null,"�������ڱ�����ڿ�ʼ����","����",JOptionPane.ERROR_MESSAGE);
				}
			}
		}
		
	}
}
