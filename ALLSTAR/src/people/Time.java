package people;

import java.io.*;
import java.time.LocalDate;

public class Time extends Thread
{
    //开始日期（创建对象时直接从文件读取）
    LocalDate beginDate;
    //结束（创建对象时直接从文件读取）
    LocalDate endDate;
    //返回现在的时间（取电脑系统时间）
    LocalDate nowDate;


    public Time()
    {
        nowDate = LocalDate.now();
        this.start();

        File file = new File("date\\beginDate.txt");
        if(!file.exists())
        {
            System.out.print("错误");
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
                read.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }
        file = new File("date\\endDate.txt");
        if(!file.exists())
        {
            System.out.print("错误");
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
                read.close();

            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }
    }

    //用local对象设置时间
    public void setBeginDate(LocalDate date)
    {
        int year = date.getYear();
        int month = date.getMonthValue();
        int day = date.getDayOfMonth();
        setBeginDate( year, month,day);
    }


    //用年月日设置时间
    public void setBeginDate(int year,int month,int day)
    {
        beginDate = LocalDate.of(year, month, day);
        File file = new File("date\\beginDate.txt");

        //文件不存在输出“错误”
        if(!file.exists())
        {
            System.out.print("错误");
        }
        else
        {
            Writer toFileReader = null;
            try {
                toFileReader = new FileWriter(file);
                BufferedWriter outBufferedWriter = new BufferedWriter(toFileReader);

                //按行读取，1、2、3行分别是年月日
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

    //用local对象设置结束时间
    public void setEndDate(LocalDate date)
    {
        int year = date.getYear();
        int month = date.getMonthValue();
        int day = date.getDayOfMonth();
        setEndDate( year, month,day);
    }

    //用年月日设置结束时间
    public void setEndDate(int year,int month,int day)
    {
        endDate = LocalDate.of(year, month, day);
        File file = new File("date\\endDate.txt");
        if(!file.exists())
        {
            System.out.print("错误");
        }
        else
        {
            Writer toFileReader = null;
            try {
                toFileReader = new FileWriter(file);
                BufferedWriter outBufferedWriter = new BufferedWriter(toFileReader);

                //按行写入，1、2、3行分别是年月日
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

    //获得开始时间
    public LocalDate getBeginDate() {
        return beginDate;
    }

    //获得结束时间
    public LocalDate getEndDate() {
        return endDate;
    }

    //获得结束时间
    public LocalDate getNowDate() {
        return nowDate;
    }

    //线程，在对象创建时开始，不断更新当前时间
    public void run()
    {
        while(true)
        {
            nowDate = LocalDate.now();
        }
    }
}