package com.qf.service;

import com.qf.pojo.Zhoubao;

import java.util.List;

public interface StudentService {

    public int GetSidByUname(String uname);

    //学生修改密码
    public int StudentUpdateUpwd(String uname);

    //周报的增删查
    public int AddWeekPaper(int sid,String zbiaoti,String zdate,String text);

    public int DeleteWeekPaper(String title);

    public List<Zhoubao> SelectWeekPaper();

    public Zhoubao StuWatchWeekPaper(int sid);

    public int StuAddWeekPaper(int sid,Zhoubao zhoubao);
}
