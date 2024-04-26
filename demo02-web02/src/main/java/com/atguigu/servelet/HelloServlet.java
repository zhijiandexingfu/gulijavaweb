package com.atguigu.servelet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HelloServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("username");
        String res = "YES";
        if(userName.equals("zhangsan")){
            res = "NO";
        }
        resp.setHeader("Content-Type","text/html");
        PrintWriter writer = resp.getWriter();
        writer.write(res);
    }
}
