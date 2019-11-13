package com.qf.controller;

import com.qf.pojo.Score;
import com.qf.pojo.ZhoubaoTeacher;
import com.qf.service.TeacherService;
import com.qf.service.TeacherServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    public TeacherService getTeacherService() {
        return teacherService;
    }

    public void setTeacherService(TeacherServiceImpl teacherService) {
        this.teacherService = teacherService;
    }

    /*
    老师批改周报打分
     */
    @RequestMapping("pigaizhoubao")
    public String pigaizhoubao(HttpSession session, HttpServletRequest request) {
        String tname = (String) session.getAttribute("uname");
        List<ZhoubaoTeacher> zhoubaoTeacherList = teacherService.selectzhoubao("杨永信");
        for (ZhoubaoTeacher Z:zhoubaoTeacherList
             ) {
            System.out.println(Z);
        }
        request.setAttribute("zhoubaoTeacherList", zhoubaoTeacherList);
        return "pigaizhoubao";
    }

    @RequestMapping("pagaizhoubaoform")
    public String pagaizhoubaoform(String sid, String score) {
        int sid1=Integer.valueOf(sid);
        int score1 = Integer.valueOf(score);
        System.out.println(sid1);
        System.out.println(score1);
        int i = teacherService.updatezhoubao(score1,sid1);
        System.out.println(i);
        if (i>0){
            return "redirect:pigaizhoubao";
        }
        return "redirect:index";
    }
    @RequestMapping("chengjiluru")
    public String tables(HttpSession session, HttpServletRequest request){
        String tname = (String) session.getAttribute("uname");
        List<Score> scoreList =  teacherService.selectscore("杨永信");
        for (Score s:scoreList
        ) {
            System.out.println(s);

        }
        request.setAttribute("scoreList", scoreList);
        return  "chengjiluru";
    }
    @RequestMapping("chengjiluruform")
    public String luruchengji (String score,String sid){
        System.out.println(score);
        System.out.println(sid);
        int sid1=Integer.valueOf(sid);
        int score1 = Integer.valueOf(score);
        System.out.println(sid1);
        System.out.println(score1);
        int i = teacherService.updatescore(score1,sid1);
        if (i>0){
            return "redirect:chengjiluru";
        }
        return "redirect:index";
    }
    @RequestMapping("chakanchengji")
    public String chengji(HttpSession session, HttpServletRequest request){
        String tname = (String) session.getAttribute("uname");
        List<Score> scoreList =  teacherService.selectscore("杨永信");
        for (Score s:scoreList
        ) {
            System.out.println(s);

        }
        request.setAttribute("scoreList", scoreList);
        return  "chakanchengji";
    }
}
