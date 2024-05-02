package com.atguigu.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/servletA")
public class ServletA extends HttpServlet {


    @Override
    //application context的属性增加
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("serviceA invoke");
        ServletContext servletContext = req.getServletContext();
        servletContext.setAttribute("keya","vala");

        //创建session对象
//        HttpSession session = req.getSession();
//        session.invalidate();
    }
}
