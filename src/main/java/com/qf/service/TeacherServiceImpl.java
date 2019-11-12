package com.qf.service;

import com.qf.mapper.TeacherMapper;
import com.qf.pojo.Score;
import com.qf.pojo.Student;
import com.qf.pojo.User;
import com.qf.pojo.ZhoubaoTeacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private  TeacherMapper teacherMapper;


    public TeacherMapper getTeacherMapper() {
        return teacherMapper;
    }

    public void setTeacherMapper(TeacherMapper teacherMapper) {
        this.teacherMapper = teacherMapper;
    }

    @Override
    public List<Score> selectscore(String tname) {
        return teacherMapper.selectscore(tname);
    }

    @Override
    public int updatescore(int score, int sid) {
        return teacherMapper.updatescore(score,sid);
    }

    @Override
    public List<Student> selectstudent(String tname) {
        return teacherMapper.selectstudent(tname);
    }

    @Override
    public int updatepassword(User user) {
        return teacherMapper.updatepassword(user);
    }

    @Override
    public List<ZhoubaoTeacher> selectzhoubao(String tname) {
        return teacherMapper.selectzhoubao(tname);
    }

    @Override
    public int updatezhoubao(int score, int sid) {
        return teacherMapper.updatezhoubao(score,sid);
    }
}
