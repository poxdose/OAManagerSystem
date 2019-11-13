package com.qf.controller;

import com.qf.pojo.*;
import com.qf.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

//超级管理员
@Controller
public class AdminController {

    @Autowired
    private AdminService adminService;

    //----------------------------------课程管理---------------------------------------------------
//添加课程
    @RequestMapping("saveKecheng")
    public String saveKecheng(Kecheng kecheng) {
        int i = adminService.addKecheng(kecheng);
        if (i > 0) {
            //重定向到某Mapping
            return "redirect:index";
        }
        return "redirect:addUser";
    }

    //删除课程
    @RequestMapping("deleteKecheng")
    @ResponseBody
    public String deleteKecheng(int kid) {
        int i = adminService.deleteKecheng(kid);
        if (i > 0) {
            System.out.println("课程删除成功");
            return "success";
        }
        return "fail";
    }

    //修改课程
//数据回显
    @RequestMapping("echoKecheng")
    public String editKecheng(int kid, Model model, HttpSession session) {
        //从session获取uname
        //   String uname = (String) session.getAttribute("uname");
        //   Student student = studentService.getStudentByUname(uname);
        Kecheng kecheng = adminService.getKechengByKid(kid);
        model.addAttribute("kecheng", kecheng);
        //带着参数跳转到回显删除页面
        return "editKecheng";
    }

    //进行修改操作
    @RequestMapping("editKecheng")
    public String updateKecheng(Kecheng kecheng) {
        int i = adminService.updateKecheng(kecheng);
        if (i > 0) {
            //修改成功重定向请求
            return "redirect:";
        }
        return "redirect:echoKecheng?kid=" + kecheng.getKid();
    }

    //进行查看操作
    @RequestMapping("kechengList")
    public String kechengList(Model model) {
        List<Kecheng> kechengList = adminService.selectKecheng();
        model.addAttribute("kechengList", kechengList);
        return "kecheng";
    }


    //----------------------------------角色管理---------------------------------------------------
    //添加
    @RequestMapping("saveRole")
    public String saveRole(Role role) {
        int i = adminService.addRole(role);
        if (i > 0) {
            //重定向到某Mapping
            return "redirect:index";
        }
        return "redirect:addUser";
    }

    //删除
    @RequestMapping("deleteRole")
    @ResponseBody
    public String deleteRole(int rid) {
        int i = adminService.deleteRole(rid);
        if (i > 0) {
            System.out.println("角色删除成功");
            return "success";
        }
        return "fail";
    }

    //修改
    //数据回显
    @RequestMapping("echoRole")
    public String editRole(int rid, Model model, HttpSession session) {
        //从session获取uname
        //   String uname = (String) session.getAttribute("uname");
        //   Student student = studentService.getStudentByUname(uname);
        Role role = adminService.getRoleByRoleid(rid);
        model.addAttribute("role", role);
        //带着参数跳转到回显删除页面
        return "juese";
    }

    //进行修改操作
    @RequestMapping("editRole")
    public String updateRole(Role role) {
        int i = adminService.updateRole(role);
        if (i > 0) {
            //修改成功重定向请求
            return "redirect:";
        }
        //role就是rid
        return "redirect:echoRole?rid=" + role.getRole();
    }

    //进行查看操作
    @RequestMapping("roleList")
    public String roleList(Model model) {
        List<Role> roleList = adminService.selectRole();
        model.addAttribute("roleList", roleList);
        return "juese";
    }

    //----------------------------------用户管理---------------------------------------------------


    //删除
    @RequestMapping("deleteUser")
    @ResponseBody
    public String deleteUser(int uid) {
        int i = adminService.deleteUser(uid);
        if (i > 0) {
            System.out.println("删除成功");
            return "success";
        }
        return "fail";
    }

    //修改
    //数据回显
    @RequestMapping("echoUser")
    public String editUser(int uid, Model model, HttpSession session) {
        //从session获取uname
        //   String uname = (String) session.getAttribute("uname");
        //   Student student = studentService.getStudentByUname(uname);
        User user = adminService.getUserByUid(uid);
        model.addAttribute("user",user);
        //带着参数跳转到回显删除页面
        return "yonghu";
    }

    //进行修改操作，只能重置密码为123456
    @RequestMapping("editUser")
    public String updateUser(User user) {
        int i = adminService.updatepassword(user);
        if (i > 0) {
            //修改成功重定向请求
            return "redirect:";
        }
        return "redirect:echoUser?uid=" + user.getUid();
    }

    //进行查看操作
    @RequestMapping("userList")
    public String userList(Model model) {
        List<Role> roleList = adminService.selectRole();
        model.addAttribute("roleList", roleList);
        return "yonghu";
    }

    //根据用户名获得结果集
    //根据uname进行搜索
    @RequestMapping("searchUser")
    public String searchUser(Model model,String uname){
        //从页面搜索框获取员工姓名
        List<User> searchUserList= adminService.selectUserByUsername(uname);
        model.addAttribute("searchUserList",searchUserList);
        return "yonghu";
    }

    //----------------------------------员工管理---------------------------------------------------

    //修改
    //数据回显
    @RequestMapping("echoTeacher")
    public String editTeacher(int tid, Model model, HttpSession session) {
        //从session获取uname
        //   String uname = (String) session.getAttribute("uname");
        //   Student student = studentService.getStudentByUname(uname);
        Teacher teacher= adminService.getTeacherByTid(tid);
        model.addAttribute("teacher",teacher);
        //带着参数跳转到回显删除页面
        return "yuangong";
    }

    //进行修改操作
    @RequestMapping("editTeacher")
    public String updateTeacher(Teacher teacher) {
        int i = adminService.updateTeacher(teacher);
        if (i > 0) {
            //修改成功重定向请求
            return "redirect:";
        }
        return "redirect:echoTeacher?tid=" + teacher.getTid();
    }

    //进行查看操作
    @RequestMapping("teacherList")
    public String teacherList(Model model) {
        List<Teacher> teacherList = adminService.selectTeacher();
        model.addAttribute("teacherList", teacherList);
        return "yuangong";
    }

    //根据tname进行搜索
    @RequestMapping("searchTeacher")
    public String searchTeacher(Model model,String tname){
        //从页面搜索框获取员工姓名
       List<Teacher> searchTeacherList= adminService.selectTeacherByTeachername(tname);
       model.addAttribute("searchTeacherList",searchTeacherList);
       return "yuangong";
    }


    //----------------------------------班级管理---------------------------------------------------
    //包含分配讲师，班主任
    //添加
    @RequestMapping("saveClass")
    public String saveClass(Clazz clazz) {
        int i = adminService.addClass(clazz);
        if (i > 0) {
            //重定向到某Mapping
            return "redirect:index";
        }
        return "redirect:addUser";
    }

    //删除
    @RequestMapping("deleteClass")
    @ResponseBody
    public String deleteClass(int cid) {
        int i = adminService.deleteClass(cid);
        if (i > 0) {
            System.out.println("class删除成功");
            return "success";
        }
        return "fail";
    }

    //修改
    //数据回显
    @RequestMapping("echoClass")
    public String editClass(int cid, Model model, HttpSession session) {
        //从session获取uname
        //   String uname = (String) session.getAttribute("uname");
        //   Student student = studentService.getStudentByUname(uname);
        Clazz clazz = adminService.getClassByCid(cid);
        model.addAttribute("clazz",clazz);
        //带着参数跳转到回显删除页面
        return "banji";
    }

    //进行修改操作
    @RequestMapping("editClass")
    public String updateClass(Clazz clazz) {
        int i = adminService.updateClass(clazz);
        if (i > 0) {
            //修改成功重定向请求
            return "redirect:";
        }
        return "redirect:echoClass?cid=" + clazz.getCid();
    }

    //进行查看操作
    @RequestMapping("classList")
    public String classList(Model model) {
        List<Clazz> classList = adminService.selectClass();
        model.addAttribute("classList", classList);
        return "banji";
    }

}
