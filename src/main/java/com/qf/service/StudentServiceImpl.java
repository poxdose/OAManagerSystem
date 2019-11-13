package com.qf.service;

import com.qf.mapper.StudentMapper;
import com.qf.pojo.Zhoubao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;

    public StudentMapper getStudentMapper() {
        return studentMapper;
    }

    public void setStudentMapper(StudentMapper studentMapper) {
        this.studentMapper = studentMapper;
    }

    @Override
    public int GetSidByUname(String uname) {
        return studentMapper.GetSidByUname(uname);
    }

    @Override
    public int StudentUpdateUpwd(String uname) {
        return 0;
    }

    @Override
    public int AddWeekPaper(int sid,String zbiaoti, String zdate, String text) {
        return studentMapper.AddWeekPaper(sid,zbiaoti,zdate,text);
    }

    @Override
    public int DeleteWeekPaper(String title) {
        return 0;
    }

    @Override
    public List<Zhoubao> SelectWeekPaper() {
        return null;
    }

    @Override
    public Zhoubao StuWatchWeekPaper(int sid) {
        return studentMapper.StuWatchWeekPaper(sid);
    }

    @Override
    public int StuAddWeekPaper(int sid,Zhoubao zhoubao) {
        return studentMapper.AddWeekPaper(sid,zhoubao.getZbiaoti(),zhoubao.getZdate(),zhoubao.getText());
    }
}
