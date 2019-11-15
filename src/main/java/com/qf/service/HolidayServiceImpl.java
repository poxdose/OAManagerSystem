package com.qf.service;

import com.qf.mapper.HolidayMapper;
import com.qf.pojo.Holiday;
import com.qf.service.HolidayService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class HolidayServiceImpl implements HolidayService {

    @Autowired
    private HolidayMapper holidayMapper;
    @Autowired
    private RuntimeService runtimeService;
    @Autowired
    private TaskService taskService;

    public RuntimeService getRuntimeService() {
        return runtimeService;
    }

    public void setRuntimeService(RuntimeService runtimeService) {
        this.runtimeService = runtimeService;
    }

    public TaskService getTaskService() {
        return taskService;
    }

    public void setTaskService(TaskService taskService) {
        this.taskService = taskService;
    }

    public HolidayMapper getHolidayMapper() {
        return holidayMapper;
    }

    public void setHolidayMapper(HolidayMapper holidayMapper) {
        this.holidayMapper = holidayMapper;
    }


    @Override
    public int addHolidays(Holiday holiday) {
        holidayMapper.addHoliday(holiday);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("sname", holiday.getUser().getUname());
        map.put("tname", holiday.getTname());
        map.put("ban", "jiaowenhui");
        map.put("xiao", "qqq");
        int days = getDays(holiday.getStartdate(),holiday.getEnddate());
        map.put("days",days);
        System.out.println(days);
        runtimeService.startProcessInstanceByKey("studentholiday", holiday.getHid() + "", map);
        Task task = taskService.createTaskQuery().taskAssignee(holiday.getUser().getUname()).singleResult();

        taskService.complete(task.getId());
        return holiday.getHid();
    }

    @Override
    public int addHolidayt(Holiday holiday) {
        holidayMapper.addHoliday(holiday);
        Map<String, Object> map = new HashMap<String, Object>();
        String u = holiday.getUser().getUname()+"111";
        map.put("tname", u );
        map.put("xiao", "qqq");
        runtimeService.startProcessInstanceByKey("teacherholiday", holiday.getHid() + "", map);
        Task task = taskService.createTaskQuery().taskAssignee(u).singleResult();

        taskService.complete(task.getId());
        return holiday.getHid();
    }

    @Override
    public List<Holiday> getApproveHolidayList(String uname) {
        List<Holiday>    approveHolidayList = holidayMapper.getApproveHolidayList(uname);
        return approveHolidayList;
    }

    @Override
    public List<Holiday> getApproveHolidayList1(String uname) {
        List<Task> list = taskService.createTaskQuery().taskAssignee(uname).list();
        List<String> bussinessKeys = new ArrayList<String>();
        for (Task task : list) {
            ProcessInstance processInstance = runtimeService.createProcessInstanceQuery()
                    .processInstanceId(task.getProcessInstanceId()).singleResult();
            bussinessKeys.add(processInstance.getBusinessKey());
        }
        List<Holiday> approveHolidayList = new ArrayList<Holiday>();
        if(list.size()>0) {
            approveHolidayList = holidayMapper.getApproveHolidayList1(bussinessKeys);
        }
        return approveHolidayList;
    }

    @Override
    public int selectuidbyuname(String uname) {
        return holidayMapper.selectuidbyuname(uname);
    }

    @Override
    public int getstatebyhid(int hid) {
        return holidayMapper.getstatebyhid(hid);
    }


    @Override
    public int updateHoliday(int hid, int state, String uname) {

        Task task = taskService.createTaskQuery().processInstanceBusinessKey(hid + "").taskAssignee(uname).singleResult();
        taskService.complete(task.getId());
        return holidayMapper.updateHoliday(hid, state);
    }
    /**
     * 根据日期获取天数
     * @param startDate
     * @param endDate
     * @return
     */
    private int getDays(String startDate, String endDate) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date start = null;
        Date end = null;
        try {
            start = simpleDateFormat.parse(startDate);
            end = simpleDateFormat.parse(endDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        long daysTime = end.getTime() - start.getTime();
        int days = (int)daysTime/(24*60*60*1000);
        return days;
    }
}

