
package com.qf.controller;

import com.qf.pojo.Score;
import com.qf.pojo.Student;
import com.qf.pojo.ZhoubaoTeacher;
import com.qf.service.TeacherService;
import com.qf.service.TeacherServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class a {
    @Autowired
    private TeacherService teacherService;

    public TeacherService getTeacherService() {
        return teacherService;
    }

    public void setTeacherService(TeacherServiceImpl teacherService) {
        this.teacherService = teacherService;
    }

    @RequestMapping("index")
    public String index(){
        return  "index";
    }
    @RequestMapping("forms")
    public String Forms(){
        return  "forms";
    }
    @RequestMapping("chengjiluru")
    public String tables(){

List<Score> score =  teacherService.selectscore("杨永信");
        for (Score s:score
             ) {
            System.out.println(s);

        }
        List<Student> students = teacherService.selectstudent("杨永信");
        for (Student s:students
             ) {
            System.out.println(s);
        }
        int i = teacherService.updatescore(70,1);
        System.out.println(i);
List<ZhoubaoTeacher> zhoubaoTeachers=   teacherService.selectzhoubao("杨永信");
        for (ZhoubaoTeacher z:zhoubaoTeachers
             ) {
            System.out.println(z);
        }
        teacherService.updatezhoubao(70,1);
        return  "chengjiluru";
    }


}