package com.qf.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qf.pojo.*;
import com.qf.service.HeadTeacherService;
import com.qf.service.HeadTeacherServiceImpl;
import jdk.nashorn.internal.ir.RuntimeNode;
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
        return "xueshengxinxitianru";
    }

    @RequestMapping("studentmanager")
    public String studentmanager( Model model){
        List<Student> studentList = headTeacherService.getUserList();
        model.addAttribute("studentList",studentList);
        return "xueshengxinxi";
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

    @RequestMapping("chaxunavgscore")
    public String classjieduan1(String cname , Model model){
        List<Score> scoreList = headTeacherService.getClazzAvgScore1(cname);
        List<Score> jieduanList = headTeacherService.getClazzAvgScore2(cname);
        model.addAttribute("scoreList",scoreList);
        model.addAttribute("jieduanList",jieduanList);
        return "echart1";
    }



    @RequestMapping("gejieduanscore")
    public String classjieduan1(String sname,String kname, Model model){
        List<Score> scoreList = headTeacherService.getStudentScoreByJieduan1(sname,kname);
        model.addAttribute("scoreList",scoreList);
        List<Score> kechengList = headTeacherService.getStudentScoreByJieduan2(sname,kname);
        model.addAttribute("kechengList",kechengList);
        return "echart2";
    }

    @RequestMapping("loginavgscore")
    public String avgscore(){
        return "avgscore";
    }
    @RequestMapping("logingerenscore")
    public String gerenscore(){
        return "gerenscore";
    }
}
