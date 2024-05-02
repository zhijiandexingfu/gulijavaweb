package com.atguigu.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LifeCycleFilter implements Filter {

    public LifeCycleFilter() {
        System.out.println("实例化");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        String dateFormat = filterConfig.getInitParameter("DateFormat");
        System.out.println("dateFormat is :" + dateFormat);
        System.out.println("初始化");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("LifeCycleFilter 被调用");
    }

    @Override
    public void destroy() {
        System.out.println("被销毁");

    }
}
