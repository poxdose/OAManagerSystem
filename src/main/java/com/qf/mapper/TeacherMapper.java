package com.qf.mapper;

import com.qf.pojo.*;

import java.util.List;

public interface TeacherMapper {


public  List<Score> selectscore(String tname);
public int updatescore(int score,int sid);
public List<Student> selectstudent(String tname);
public int updatepassword(User user);
public List<ZhoubaoTeacher> selectzhoubao(String tname);
public int updatezhoubao(int score,int sid);

}
