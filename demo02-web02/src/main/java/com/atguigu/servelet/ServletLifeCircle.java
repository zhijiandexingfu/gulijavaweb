package com.atguigu.servelet;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/servletLifeCircle",loadOnStartup = 6)
public class ServletLifeCircle extends HttpServlet {


    public ServletLifeCircle() {
        System.out.println("开始实例化了");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        System.out.println("开始执行get方法");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doPost(req, resp);
        System.out.println("开始执行post方法");

    }

    @Override
    public void destroy() {
        System.out.println("终止了");
    }

    @Override
    public void init() throws ServletException {
        System.out.println("开始初始化了");
    }

//    @Override
//    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println("开始service方法了");
//    }

}
