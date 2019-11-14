package com.qf.controller;


import com.qf.pojo.User;
import com.qf.pojo.Zhoubao;
import com.qf.service.StudentServiceImpl;
import com.qf.service.UserServiceImpl;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class UserController {


    @Autowired
private UserServiceImpl userServiceImpl;

    public UserServiceImpl getUserServiceImpl() {
        return userServiceImpl;
    }

    public void setUserServiceImpl(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }
    @Autowired
    private SecurityManager securityManager;

    public SecurityManager getSecurityManager() {
        return securityManager;
    }

    public void setSecurityManager(SecurityManager securityManager) {
        this.securityManager = securityManager;
    }


    @Autowired
    private StudentServiceImpl studentServiceImpl;

    public StudentServiceImpl getStudentServiceImpl() {
        return studentServiceImpl;
    }

    public void setStudentServiceImpl(StudentServiceImpl studentServiceImpl) {
        this.studentServiceImpl = studentServiceImpl;
    }

    @RequestMapping("loginPage")
    public String loginPage(){
        return "login";
    }


    @RequestMapping("login1")
    public String login(User user){
        String uname = user.getUname();
            System.out.println(user.getUname());
            System.out.println(user.getUpwd());
        SecurityUtils.setSecurityManager(securityManager);
        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(user.getUname(),user.getUpwd());
        try{
            System.out.println(usernamePasswordToken);
            subject.login(usernamePasswordToken);
            if(subject.isAuthenticated()){
                Session session = subject.getSession();
                //User user = userServiceImpl.getuser(uname);
                //session.setAttribute("user",user);
                session.setAttribute("uname",uname);
                return "index";
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return "redirect:loginPage";
    }

    @RequestMapping("gerenmansage1")
    public String gerenmansage(){



        return "gerenmansage";
    }


    @RequestMapping("edit1")
    public String edit(String upwd1, HttpServletRequest request, HttpSession session){

        String uname = (String) session.getAttribute("uname");

        String upwd = userServiceImpl.getMD5String(upwd1);

        int i = userServiceImpl.editupwd(upwd,uname);
        return "index";
    }



    @RequestMapping("addweekpaper")
    public String addweekpaper(){



        return "writezhoubao";
    }

    @RequestMapping("stuaddzhoubao")
    public String stuaddzhoubao(Zhoubao zhoubao,HttpServletRequest request, HttpSession session){
        String uname = (String) session.getAttribute("uname");


        System.out.println(zhoubao.getZbiaoti());
        System.out.println(zhoubao.getText());
        System.out.println(zhoubao.getZdate());
        int uid = studentServiceImpl.GetSidByUname(uname);

        int i = studentServiceImpl.AddWeekPaper(uid,zhoubao.getZbiaoti(),zhoubao.getZdate(),zhoubao.getText());

        return "index";
    }

    @RequestMapping("watchweekpaper")
    public String watchweekpaper(HttpServletRequest request, HttpSession session){
        String uname = (String) session.getAttribute("uname");
        int uid = studentServiceImpl.GetSidByUname(uname);
        Zhoubao zhoubao = studentServiceImpl.StuWatchWeekPaper(uid);
        System.out.println(zhoubao);
        request.setAttribute("uname",uname);
        request.setAttribute("zhoubao",zhoubao);
        return "stuchakanzhoubao";
    }


    @RequestMapping("studeleteweek")
    public String studeleteweek(){



        return "studeleteweekpaper";
    }
}
