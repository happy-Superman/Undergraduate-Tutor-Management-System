package admin;


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

public class modifyTime extends JFrame
{
    //开始时间标签
    JLabel beginTime = new JLabel("开始时间");
    //结束时间标签
    JLabel endTime = new JLabel("结束时间");
    //开始年月日的下拉列表
    JComboBox beginYear = new JComboBox();
    JComboBox beginMonth = new JComboBox();
    JComboBox beginDay = new JComboBox();
    //结束年月日的下拉列表
    JComboBox endYear = new JComboBox();
    JComboBox endMonth = new JComboBox();
    JComboBox endDay = new JComboBox();
    //修改按钮
    JButton revise = new JButton("修改");
    //时间类获得原开始结束时间
    Time time = new Time();


    public modifyTime()
    {
        super("修改系统开放时间");
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

    //布局方式
    void setFrame()
    {
        Box beginBox = Box.createHorizontalBox();
        Box endBox = Box.createHorizontalBox();
        Box reviseBox  = Box.createHorizontalBox();
        Box box = Box.createVerticalBox();


        beginBox.add(Box.createHorizontalStrut(40));
        beginBox.add(beginTime);beginBox.add(Box.createHorizontalStrut(10));
        beginBox.add(beginYear);beginBox.add(new JLabel("年"));
        beginBox.add(beginMonth);beginBox.add(new JLabel("月"));
        beginBox.add(beginDay);beginBox.add(new JLabel("日"));

        endBox.add(Box.createHorizontalStrut(40));
        endBox.add(endTime);endBox.add(Box.createHorizontalStrut(10));
        endBox.add(endYear);endBox.add(new JLabel("年"));
        endBox.add(endMonth);endBox.add(new JLabel("月"));
        endBox.add(endDay);endBox.add(new JLabel("日"));

        reviseBox.add(revise);

        box.add(Box.createVerticalStrut(30));
        box.add(beginBox);box.add(Box.createVerticalStrut(40));
        box.add(endBox);box.add(Box.createVerticalStrut(50));
        box.add(reviseBox);
        box.add(Box.createVerticalStrut(40));

        add(box);
    }

    //添加下拉列表中的选择项
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

    //根据当前的月份修改日期选择项的内容
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

    //根据输入的local对象，设置列表的当前选项，用于在进入界面是显示初始项
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

                    JOptionPane.showMessageDialog(null,"修改成功","消息",JOptionPane.INFORMATION_MESSAGE);
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"结束日期必须大于开始日期","错误",JOptionPane.ERROR_MESSAGE);
                }
            }
        }

    }
}