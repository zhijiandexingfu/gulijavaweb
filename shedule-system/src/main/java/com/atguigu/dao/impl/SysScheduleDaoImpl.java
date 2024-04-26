package com.atguigu.dao.impl;

import com.atguigu.dao.BaseDao;
import com.atguigu.dao.SysScheduleDao;
import com.atguigu.entity.SysSchedule;

import java.util.List;

public class SysScheduleDaoImpl extends BaseDao implements SysScheduleDao {

    /**
     * INSERT INTO sys_schedule
     * VALUES (?, ?, ?, ?);
     *
     * @param sysSchedule
     * @return
     */
    @Override
    public int addSchedule(SysSchedule sysSchedule) {
        String sql = "INSERT INTO `sys_schedule` VALUES (DEFAULT,?,?,?)";
        int i = baseUpdate(sql,sysSchedule.getUid(),sysSchedule.getTitle(),sysSchedule.getCompleted());
        return i;
    }

    @Override
    public Long queryScheduleCnt() {
        String sql = "select  count(*) from `sys_schedule`";
        Long cnt = baseQueryObject(Long.class, sql);
        return cnt;
    }

    @Override
    public List<SysSchedule> findALlSysSchedules() {
        String sql = "select sid,uid,title,completed from sys_schedule ";
        List<SysSchedule> listSysSchedule = baseQuery(SysSchedule.class,sql);
        return listSysSchedule;
    }
}
