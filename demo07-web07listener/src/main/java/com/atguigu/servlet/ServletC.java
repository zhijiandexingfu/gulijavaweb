package com.atguigu.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/servletC")
public class ServletC extends HttpServlet {


    @Override
    //application context的属性替换
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("serviceC invoke");
        ServletContext servletContext = req.getServletContext();
        servletContext.setAttribute("keya","vala2");
    }
}
