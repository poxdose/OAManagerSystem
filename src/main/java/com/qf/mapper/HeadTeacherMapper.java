package com.qf.mapper;

import com.qf.pojo.Holiday;
import com.qf.pojo.Score;
import com.qf.pojo.Student;

import java.util.List;

public interface HeadTeacherMapper {

    //班主任修改密码
    public int TeacherUpdateUpwd(String uname);


    //周报打分
    public int WeekPaperPoint(String title,int point);

    //请假审批

    //学生成绩录入
    public String GetSnameBySid(int sid);
    public String GetCnameByCid(int cid);
    public String GetKnameByKid(int kid);
    public int AddScore(Score score);


    //学生信息查看

    public List<Student> GetStudentInfo();

    //个人请假
    public int AddHoliday(Holiday holiday);
}
