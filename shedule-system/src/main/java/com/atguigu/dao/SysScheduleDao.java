package com.atguigu.dao;

import com.atguigu.entity.SysSchedule;

import java.util.List;

public interface SysScheduleDao {
    int addSchedule(SysSchedule sysSchedule);
    Long queryScheduleCnt();
    List<SysSchedule> findALlSysSchedules();
}
