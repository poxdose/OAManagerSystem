package com.qf.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qf.pojo.Student;
import com.qf.pojo.User;
import com.qf.pojo.Zhoubao;
import com.qf.pojo.ZhoubaoTeacher;
import com.qf.service.HeadTeacherService;
import com.qf.service.HeadTeacherServiceImpl;
import org.apache.shiro.mgt.SecurityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class HeadTeacherController {
    @Autowired
    private HeadTeacherService headTeacherService;

    public HeadTeacherService getHeadTeacherService() {
        return headTeacherService;
    }

    public void setHeadTeacherService(HeadTeacherService headTeacherService) {
        this.headTeacherService = headTeacherService;
    }


    @Autowired
    private HeadTeacherServiceImpl headTeacherServiceImpl;

    public HeadTeacherServiceImpl getHeadTeacherServiceImpl() {
        return headTeacherServiceImpl;
    }

    public void setHeadTeacherServiceImpl(HeadTeacherServiceImpl headTeacherServiceImpl) {
        this.headTeacherServiceImpl = headTeacherServiceImpl;
    }

    @RequestMapping("index2")
    public String index(){
        return "index2";
    }

    @RequestMapping("xiugaimima2")
    public String xiugai(){
        return "xiugaimima";
    }

    @RequestMapping("xiugaimima")
    public String TeacherUpdateUpwd(HttpSession session , String upwd2){
        System.out.println(upwd2);
        session.getAttribute("uname");
        String uname = (String) session.getAttribute("uname");
        System.out.println(uname);
        String upwd = headTeacherServiceImpl.getMD5String(upwd2);
        System.out.println(upwd);
        headTeacherService.TeacherUpdateUpwd(uname,upwd);
                return "index";
                }

    @RequestMapping("student")
    public String stu(HttpServletRequest request){
        List<ZhoubaoTeacher> zhoubaoList = headTeacherService.WeekPaperPoint();
        for(ZhoubaoTeacher z :zhoubaoList){
            System.out.println(z);

        }
        request.setAttribute("zhoubaoList",zhoubaoList);
        return "chakanzhoubao";
    }


    @RequestMapping("addStudent")
    public String addUser(){
        return "studentadd";
    }

    @RequestMapping("studentmanager")
    public String studentmanager( Model model){
        List<Student> studentList = headTeacherService.getUserList();
        model.addAttribute("studentList",studentList);
        return "studentmanager";
    }
    /**
     * 增加用户
     * @param student
     * @return
     */
    @RequestMapping("saveStudent")
    public String saveStudent(Student student){
        int i = headTeacherService.saveStudent(student);
        if(i > 0){
            return "redirect:studentmanager";
        }
        return "redirect:addStudent";
    }

    @RequestMapping("editStudent")
    public String editStudent(int sid, Model model){
        Student student = headTeacherService.getStudentBySid(sid);
        model.addAttribute("Student",student);
        return "studentupdate";
    }

    @RequestMapping("updateStudent")
    public String updateUser(Student student){
        int i = headTeacherService.updateStudent(student);
        if(i > 0){
            return "redirect:studentmanager";
        }
        return "redirect:editStudent?sid="+student.getSid();
    }

    @RequestMapping("deleteStudent")
    @ResponseBody
    public String deleteStudent(int sid){
        int i = headTeacherService.deleteStudent(sid);
        if(i > 0){
            return "success";
        }
        return "fail";
    }
}
