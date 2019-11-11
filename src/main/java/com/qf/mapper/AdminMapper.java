package com.qf.mapper;

import com.qf.pojo.Teacher;

import java.util.List;

public interface AdminMapper {
    //课程管理
    /*public List<Kecheng> selectKecheng();
    public int addKecheng();
    public int deleteKecheng();
    public int updateKecheng();*/
    //角色管理
   /* public List<> selectRole();
    public int addRole();
    public int deleteRole();
    public int updateRole();*/
    //用户管理
/*    public List<User> selectUser();
    public int deleteUser();
    public int updatepassword();*/
//员工管理
    public List<Teacher> selectTeacher();

    public int updateTeacher();

    //班级管理
    public List<Class> selectClass();

    public int addClass();

    public int updateClass();

    public int deleteClass();

}
