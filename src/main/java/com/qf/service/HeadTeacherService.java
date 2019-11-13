package com.qf.service;

import com.qf.pojo.Student;
import com.qf.pojo.Zhoubao;
import com.qf.pojo.ZhoubaoTeacher;

import java.util.List;

public interface HeadTeacherService {
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
}
