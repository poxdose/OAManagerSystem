package com.qf.mapper;

import com.qf.pojo.Holiday;

import java.util.List;

public interface HolidayMapper {

    public int addHoliday(Holiday holiday);

    public List<Holiday> getApproveHolidayList(String uname);

    public int updateHoliday(int hid, int state);
    public List<Holiday> getApproveHolidayList1(List<String> list);
    public int selectuidbyuname(String uname);
    public int getstatebyhid(int hid);
}