package com.atguigu.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LoggingFilter implements Filter {
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd-HH:mm:ss");
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest hsr = (HttpServletRequest)servletRequest;
        HttpServletResponse hsresponse = (HttpServletResponse)servletResponse;
        String requestURL = hsr.getRequestURI();
        String time = simpleDateFormat.format(new Date());
        String beforeLogging = requestURL+"在"+time + "被访问";
        System.out.println(beforeLogging);
        Long t1 = System.currentTimeMillis();
        filterChain.doFilter(hsr,hsresponse);
        Long t2 = System.currentTimeMillis();
        String afterLogging = requestURL+"在"+time + "被访问,耗时长达"+(t2-t1)+"毫秒";
        System.out.println(afterLogging);
    }

    @Override
    public void destroy() {

    }
}
