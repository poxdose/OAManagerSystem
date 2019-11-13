package com.qf.service;

import com.qf.mapper.AdminMapper;
import com.qf.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;

    public AdminMapper getAdminMapper() {
        return adminMapper;
    }

    public void setAdminMapper(AdminMapper adminMapper) {
        this.adminMapper = adminMapper;
    }


    @Override
    public List<Kecheng> selectKecheng() {
        return adminMapper.selectKecheng();
    }

    @Override
    public int addKecheng(Kecheng kecheng) {
        return adminMapper.addKecheng(kecheng);
    }

    @Override
    public int deleteKecheng(int kid) {
        return adminMapper.deleteKecheng(kid);
    }

    @Override
    public int updateKecheng(Kecheng kecheng) {
        return adminMapper.updateKecheng(kecheng);
    }

    @Override
    public Kecheng getKechengByKid(int kid) {
        return adminMapper.getKechengByKid(kid);
    }

    @Override
    public List<Role> selectRole() {
        return adminMapper.selectRole();
    }

    @Override
    public int addRole(Role role) {
        return adminMapper.addRole(role);
    }

    @Override
    public int deleteRole(int roleid) {
        return adminMapper.deleteRole(roleid);
    }

    @Override
    public int updateRole(Role role) {
        return adminMapper.updateRole(role);
    }

    @Override
    public Role getRoleByRoleid(int roleid) {
        return adminMapper.getRoleByRoleid(roleid);
    }

    @Override
    public List<User> selectUser() {
        return adminMapper.selectUser();
    }

    @Override
    public int deleteUser(int uid) {
        return adminMapper.deleteUser(uid);
    }

    @Override
    public int updatepassword(User user) {
        return adminMapper.updatepassword(user);
    }

    @Override
    public User getUserByUid(int uid) {
        return adminMapper.getUserByUid(uid);
    }

    //模糊查询获得结果集
    @Override
    public List<User> selectUserByUsername(String uname) {
        return adminMapper.selectUserByUsername(uname);
    }

    @Override
    public List<Teacher> selectTeacher() {
        return adminMapper.selectTeacher();
    }

    @Override
    public int updateTeacher(Teacher teacher) {
        return adminMapper.updateTeacher(teacher);
    }

    @Override
    public List<Teacher> selectTeacherByTeachername(String tname) {
        return adminMapper.selectTeacherByTeachername(tname);
    }

    @Override
    public Teacher getTeacherByTid(int tid) {
        return adminMapper.getTeacherByTid(tid);
    }

    @Override
    public List<Clazz> selectClass() {
        return adminMapper.selectClass();
    }

    @Override
    public int addClass(Clazz clazz) {
        return adminMapper.addClass(clazz);
    }

    @Override
    public int updateClass(Clazz clazz) {
        return adminMapper.updateClass(clazz);
    }

    @Override
    public int deleteClass(int cid) {
        return adminMapper.deleteClass(cid);
    }

    @Override
    public Clazz getClassByCid(int cid) {
        return adminMapper.getClassByCid(cid);
    }
}
