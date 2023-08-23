package teacher;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class selectStudent {
    /*
     首先要在下拉列表框中获得学生姓名
     然后对学生进行相应操作  比如选中获得是拒绝
     如果是选中 把学生的状态设置 state设置为1 表示已有导师 对应工号不变 这样查看自己的学生时
     就可以找学生中state为1 并且工号是自己的 即为自己的学生
     如果拒绝 设置state为0
     */
    public String studentNumber;

    public void selectStudent(){

        //在下拉列表中获取选中的
        studentBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedStudent = (String) comboBox.getSelectedItem();
            }
        });

        studentNumber = selectedStudent;  //在前面的下拉列表中获得选中的学生
        //监听设置选中按钮
        selecteButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                //根据学生学号 因为姓名可能会出现重名的情况 根据对应学号找到学生 把状态改为1
                db.changeState(studentNumber,1);
            }
        });

        rejectButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                //设置state为0 学生可以重新选择其他老师
                db.changeState(studentNumber,0);
            }
        });

        mystudentButton.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e){
               //把数据库中学生状态是1 并且对应老师工号是自己的学生显示出来
//               没想出怎么写
           }
        });
    }
}
