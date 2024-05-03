package com.atguigu.controller;

import com.atguigu.dao.SysUserDao;
import com.atguigu.entity.SysUser;
import com.atguigu.service.SysUserService;
import com.atguigu.service.impl.SysUserServiceImpl;
import com.atguigu.util.MD5Util;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/user/*")
public class SysUserController extends BaseController {
    SysUserService sysUserService = new SysUserServiceImpl();

    protected void add(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("add");
    }

    protected void regist(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //获取参数
        String username = req.getParameter("username");
        String userPwd = req.getParameter("userPwd");
        SysUser sysUser = new SysUser(null, username, userPwd);
        int register = sysUserService.register(sysUser);
        if (register > 0) {
            resp.sendRedirect("/registerSuccess.html");
        } else {
            resp.sendRedirect("/registerFail.html");
        }
    }

    protected void login(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //获取参数
        String username = req.getParameter("username");
        String userPwd = req.getParameter("userPwd");
        SysUser sysUser = sysUserService.findByname(username);
        if (sysUser == null) {
            resp.sendRedirect("/LoginUserNameFail.html");
            System.out.println("登录失败，用户名错误");
        } else if (!sysUser.getUserPwd().equals(MD5Util.encrypt(userPwd))) {
            resp.sendRedirect("/LoginPwdFail.html");
            System.out.println("登录失败，密码错误");

        } else {
            HttpSession session = req.getSession();
            session.setAttribute("sysUser",sysUser);
            resp.sendRedirect("/ShowSchdule.html");
            System.out.println("登录成功");
        }
    }

}
