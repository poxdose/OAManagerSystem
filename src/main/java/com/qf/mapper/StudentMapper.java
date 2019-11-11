package com.qf.mapper;

import com.qf.pojo.Zhoubao;

import java.util.List;

public interface StudentMapper {

    //学生修改密码
    public int StudentUpdateUpwd(String uname);

    //周报的增删查
    public int AddWeekPaper(String title,String Datetime,String info);

    public int DeleteWeekPaper(String title);

    public List<Zhoubao> SelectWeekPaper();

}
