package com.atguigu.controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/schedule/*")
public class SysScheduleController extends BaseController{
    protected void add(HttpServletRequest req, HttpServletResponse resp){
        System.out.println("add");
    }
}
