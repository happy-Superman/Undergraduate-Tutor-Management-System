package student;

import java.awt.event.ActionEvent;

public class selectTutor {
    String selectedTeacher;
    public selectTutor(){
        //关于数量问题 采用导入到界面列表时进行判断 如果学生数大于最大数 则不显示

//      学生确认选择某位老师的按钮
//        点击后把该学生的信息中选择导师改为对应老师的工号 这样老师查看的时候只查自己工号的学生
//        并且设置状态 冻结状态 无法选择其他老师
//        状态实现的方式时修改在数据库中的值
//        首先在数据库中该学生的状态中读取
//        如果state=2 则在此界面 但是无法点击确认按钮
//        如果老师选择了他 则把状态改成1  如果拒绝了则改为状态0
        try {
            db = new AccessDatabase();
//            accounts = db.getAllAccounts();
//            这里的db连接到数据库 然后调用里面的方法即可
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        state = db.findState();
        //正常选导师


        //在下拉列表中获得信息  获得选中的老师姓名
        teacherBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedTeacher = (String) comboBox.getSelectedItem();
            }
        });

        //状态0 正常进行导师选择
        if(state == 0){
            comfirmButton.setEnabled(true);
            comfirmButton.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    teacherName = selectedTeacher;  //在前面的下拉列表中获得
                    //根据老师的姓名获得老师的工号
                    teacherNumber = db.findTeacherNumber(teacherName);
                    //把学生的导师待选数据改为老师的工号
                    db.changePendingTutor(studentNumber,teacherNumber);
                    //把学生的状态设置为2 冻结确认按钮
                    db.changeState(studentNumber,2);  //修改该同学的state为2 冻结按钮
                    comfirmButton.setEnabled(false);
                }
            });
        }
        //冻结按钮
        else if(state == 2){
            comfirmButton.setEnabled(false);
        }

        //修改信息的按钮
        changeButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                   new studentMessage();
            }
        });


    }
}
/*
state 0 进入选择导师
        ， 1 have
        ， 2 选择界面 点击过确认键 老师正在审核 这个确认按钮冻结
pendingTutor  导师的工号
 */


