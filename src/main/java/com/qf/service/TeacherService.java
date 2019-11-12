package com.qf.service;

import com.qf.pojo.Score;
import com.qf.pojo.Student;
import com.qf.pojo.User;
import com.qf.pojo.ZhoubaoTeacher;

import java.util.List;

public interface TeacherService {
    public  List<Score> selectscore(String tname);
    public int updatescore(int score,int sid);
    public List<Student> selectstudent(String tname);
    public int updatepassword(User user);
    public List<ZhoubaoTeacher> selectzhoubao(String tname);
    public int updatezhoubao(int score,int sid);
}
