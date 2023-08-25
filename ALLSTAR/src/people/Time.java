package people;

import java.io.*;
import java.lang.reflect.Field;
import java.security.PublicKey;
import java.time.LocalDate;
import java.util.Set;

public class Time extends Thread
{
    LocalDate beginDate;
    LocalDate endDate;
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
    public void setBeginDate(int year,int month,int day)
    {
        beginDate = LocalDate.of(year, month, day);
        File file = new File("date\\beginDate.txt");
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
    public LocalDate getBeginDate() {
        return beginDate;
    }
    public LocalDate getEndDate() {
        return endDate;
    }
    public LocalDate getNowDate() {
        return nowDate;
    }
    public void run()
    {
        while(true)
        {
            nowDate = LocalDate.now();
        }
    }
}
