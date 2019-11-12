package com.qf.controller;


import com.qf.pojo.User;
import com.qf.service.UserServiceImpl;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.apache.shiro.mgt.SecurityManager;

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
        return "loginsim";
    }


    @RequestMapping("login")
    public String login(User user){
        String uname = user.getUname();
            /*System.out.println(user.getUname());
            System.out.println(user.getUpwd());*/
        SecurityUtils.setSecurityManager(securityManager);
        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(user.getUname(),user.getUpwd());
        try{
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


}
