
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


    @RequestMapping("forms")
    public String Forms(){
        return  "juese";
    }
    @RequestMapping("chengjiluru2")
    public String tables(){

List<Score> score =  teacherService.selectscore("杨永信");
        for (Score s:score
             ) {
            System.out.println(s);

        }

        return  "chengjiluru";
    }


}