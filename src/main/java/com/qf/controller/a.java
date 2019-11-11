package com.qf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class a {
    @RequestMapping("index")
    public String index(){
        return  "index";
    }
}
