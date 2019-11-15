package com.qf.controller;

import com.qf.pojo.Holiday;
import com.qf.pojo.User;
import com.qf.service.HolidayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class HoildayController {
    @Autowired
    private HolidayService holidayService;

    public HolidayService getHolidayService() {
        return holidayService;
    }

    public void setHolidayService(HolidayService holidayService) {
        this.holidayService = holidayService;
    }

    @Autowired
    public User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
    @RequestMapping("shengqingjia")
    public String add() {
        return "shenqingholiday";
    }

    @RequestMapping("saveHolidays")
    public String saveHoliday(Holiday holiday, HttpSession session) {
       /* String uname = (String) session.getAttribute("uname");
        int uid = holidayService.selectuidbyuname(uname);*/
       int uid=1;
      String uname="user1";
        user.setUid(uid);
        user.setUname(uname);
        holiday.setUser(user);
        holidayService.addHolidays(holiday);
        return "index";
      //  "redirect:getHolidays"
    }
    @RequestMapping("saveHolidayt")
    public String saveHolidayt(Holiday holiday, HttpSession session) {
        String uname = (String) session.getAttribute("uname");
        int uid = holidayService.selectuidbyuname(uname);
        user.setUid(uid);
        user.setUname(uname);

        holiday.setUser(user);
        holidayService.addHolidayt(holiday);
        return "redirect:getHolidays";
    }
    @RequestMapping("getHolidays")
    public String getHolidays(HttpServletRequest request, HttpSession session) {
        String uname = (String) session.getAttribute("uname");
        List<Holiday> holidayList = holidayService.getApproveHolidayList1(uname);
        for (Holiday holiday : holidayList) {
            System.out.println(holiday);
        }
        request.setAttribute("holidayList", holidayList);
        return "shenpijiatiao";
    }

    @RequestMapping("getHoliday")
    public String getHoliday(HttpServletRequest request,HttpSession session) {
        String uname = (String) session.getAttribute("uname");

        List<Holiday> holidayList = holidayService.getApproveHolidayList(uname);
        for (Holiday holiday : holidayList) {
            System.out.println(holiday);
        }
        request.setAttribute("holidayList", holidayList);
        return "chakanjiatiao";
    }

    @RequestMapping("updateHoliday")
    public String updateHoliday(int hid,HttpSession session) {
       String uname = (String) session.getAttribute("uname");
        int state = holidayService.getstatebyhid(hid);
        int state1 =state+1;
        System.out.println(state1);
        holidayService.updateHoliday(hid, state1, uname);
        return "redirect:getHolidays";
    }
}
