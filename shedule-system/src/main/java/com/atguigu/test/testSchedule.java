package com.atguigu.test;

import com.atguigu.dao.impl.SysScheduleDaoImpl;
import com.atguigu.entity.SysSchedule;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

@Test
public class testSchedule {
    private static SysScheduleDaoImpl sysScheduleImpl;

    @BeforeClass
    private static void initSysScheduleImpl(){
        sysScheduleImpl = new SysScheduleDaoImpl();
    }

    @Test
    public static void testSysScheduleImpl() {
        SysSchedule sysSchedule = new SysSchedule(null,2,"Redis实战",1);
        sysScheduleImpl.addSchedule(sysSchedule);
    }

    @Test
    public static void testSysScheduleCntImpl() {
        Long cnt = sysScheduleImpl.queryScheduleCnt();
        System.out.println(cnt);
    }

    @Test
    public static void testSysSchedulefindallImpl() {
        List<SysSchedule> aLlSysSchedules = sysScheduleImpl.findALlSysSchedules();
        aLlSysSchedules.forEach(System.out::println);
    }
}
