package com.qf.controller;


import com.qf.pojo.User;
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
                return "gerenmansage";
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return "redirect:loginPage";
    }


    @RequestMapping("edit")
    public String edit(){



        return "editupwd";
    }

    @RequestMapping("edit1")
    public String edit(String upwd1, HttpServletRequest request, HttpSession session){

        String uname = (String) session.getAttribute("uname");

        String upwd = userServiceImpl.getMD5String(upwd1);

        int i = userServiceImpl.editupwd(upwd,uname);
        return "index";
    }


}
