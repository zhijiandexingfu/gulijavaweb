package com.atguigu.controller;

import com.alibaba.druid.support.json.JSONUtils;
import com.atguigu.common.Result;
import com.atguigu.common.ResultCodeEnum;
import com.atguigu.dao.SysUserDao;
import com.atguigu.entity.SysUser;
import com.atguigu.service.SysUserService;
import com.atguigu.service.impl.SysUserServiceImpl;
import com.atguigu.util.MD5Util;
import com.atguigu.util.WebUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

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
//        String username = req.getParameter("username");
//        String userPwd = req.getParameter("userPwd");
        SysUser sysUser = WebUtil.readJson(req, SysUser.class);
//        SysUser sysUser = new SysUser(null, username, userPwd);
        int register = sysUserService.register(sysUser);
        Result result = Result.ok(null);
        if (register < 1) {
            result = Result.build(null,ResultCodeEnum.REGISTER_EXISTED_FAIL);
//            resp.sendRedirect("/registerSuccess.html");
        } else {
            WebUtil.writeJson(resp,result);
        }
    }


    protected void checkUsername(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String username = req.getParameter("username");
//        String info = "valid";
        SysUser sysUser = sysUserService.findByname(username);
        Result<SysUser> result = Result.ok(null);
        if(sysUser != null){
//            info = "not valid";
            result = Result.build(null, ResultCodeEnum.REGISTER_EXISTED_FAIL);
        }
        WebUtil.writeJson(resp,result);
    }

    protected void login(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //获取参数
//        String username = req.getParameter("username");
//        String userPwd = req.getParameter("userPwd");
        SysUser sysUserRaw = WebUtil.readJson(req, SysUser.class);
        SysUser sysUser = sysUserService.findByname(sysUserRaw.getUserName());
        Result result = Result.ok(null);
        if (sysUser == null) {
//            resp.sendRedirect("/LoginUserNameFail.html");
            System.out.println("登录失败，用户名错误");
            result = Result.build(null,ResultCodeEnum.LOGIN_USER_NAME_FAIL);
        } else if (!sysUser.getUserPwd().equals(MD5Util.encrypt(sysUserRaw.getUserPwd()))) {
//            resp.sendRedirect("/LoginPwdFail.html");
            result = Result.build(null,ResultCodeEnum.LOGIN_PWD_FAIL);
            System.out.println("登录失败，密码错误");
        } else {
            result = Result.build(null,ResultCodeEnum.LOGIN_SUCCESS);
            System.out.println("登录成功");
        }
        WebUtil.writeJson(resp,result);
    }

}
