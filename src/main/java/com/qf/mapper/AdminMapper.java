package com.qf.mapper;

import com.qf.pojo.*;

import java.util.List;

public interface AdminMapper {
    //课程管理
    public List<Kecheng> selectKecheng();
    public int addKecheng(Kecheng kecheng);
    public int deleteKecheng(int kid);
    public int updateKecheng(Kecheng kecheng);
    //角色管理
    public List<Role> selectRole();
    public int addRole(Role role);
    public int deleteRole(int roleid);
    public int updateRole(Role role);
    //用户管理
    public List<User> selectUser();
    public int deleteUser(int uid);
    public int updatepassword(User user);
    //根据用户名模糊查询用户
    public List<User> selectUserByUsername(String uname);
    //员工管理
    public List<Teacher> selectTeacher();

    public int updateTeacher(Teacher teacher);
    //根据员工名模糊查询员工
    public List<User> selectTeacherByTeachername(String tname);
    //班级管理
    public List<Clazz> selectClass();

    public int addClass(Clazz clazz);

    public int updateClass(Clazz clazz);

    public int deleteClass(int cid);



}
