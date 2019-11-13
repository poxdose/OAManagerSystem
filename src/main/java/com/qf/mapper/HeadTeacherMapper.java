package com.qf.mapper;

import com.qf.pojo.*;

import java.util.List;

public interface HeadTeacherMapper {

    //班主任修改密码
    public int TeacherUpdateUpwd(String uname,String upwd);


    //周报查看
    public List<ZhoubaoTeacher> WeekPaperPoint();

    //学生信息管理
    public int saveStudent(Student student);

    public int deleteStudent(int sid);

    public int updateStudent(Student student);

    public List<Student> getUserList();

    public Student getStudentBySid(int sid);

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
