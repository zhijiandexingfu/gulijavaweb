package com.atguigu.controller;

import com.atguigu.dao.SysUserDao;
import com.atguigu.entity.SysUser;
import com.atguigu.service.SysUserService;
import com.atguigu.service.impl.SysUserServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user/*")
public class SysUserController extends BaseController{
    protected void add(HttpServletRequest req, HttpServletResponse resp){
        System.out.println("add");
    }
    protected void regist(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //获取参数
        String username = req.getParameter("username");
        String userPwd = req.getParameter("userPwd");
        SysUser sysUser = new SysUser(null,username,userPwd);
        SysUserService sysUserService = new SysUserServiceImpl();
        int register = sysUserService.register(sysUser);
        if(register>0){
            resp.sendRedirect("/registerSuccess.html");
        }else{
            resp.sendRedirect("/registerFail.html");
        }


    }

}
