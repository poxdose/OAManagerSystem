package com.qf.service;

import com.qf.pojo.Holiday;

import java.util.List;

public interface HolidayService {

    public int addHolidays(Holiday holiday);
    public int addHolidayt(Holiday holiday);
    public List<Holiday> getApproveHolidayList(String uname);

    public int updateHoliday(int hid, int state, String uname);
    public List<Holiday> getApproveHolidayList1(String uname);
    public int selectuidbyuname(String uname);
    public int getstatebyhid(int hid);
}