package com.qf.mapper;

public interface TeacherMapper {

    //老师修改密码
    public int TeacherUpdateUpwd(String uname);


    //周报打分
    public int WeekPaperPoint(String title,int point);

    //请假审批


}
