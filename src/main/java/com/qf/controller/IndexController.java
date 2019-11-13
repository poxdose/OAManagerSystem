package com.qf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    @RequestMapping("index")
    public String index() {
        return "index";
    }
    /*
    个人信息管理  修改密码界面
     */
    @RequestMapping("gerenmansage")
    public String gerenmansage() {
        return "gerenmansage";
    }

    /*
    学生填写周报界面
     */
    @RequestMapping("writezhoubao")
    public String writezhoubao() {
        return "writezhoubao";
    }


    /*
 查看周报
  */
    @RequestMapping("chakanzhoubao")
    public String chakanzhoubao() {
        return "chakanzhoubao";
    }

    /*
申请假条
*/
    @RequestMapping("shenqingholiday")
    public String shenqingholiday() {
        return "shenqingholiday";
    }

    /*
审批假条
*/
    @RequestMapping("shenpijiatiao")
    public String shenpijiatiao() {
        return "shenpijiatiao";
    }

}
