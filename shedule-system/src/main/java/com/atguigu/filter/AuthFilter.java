package com.atguigu.filter;

import com.atguigu.entity.SysUser;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

//@WebFilter(urlPatterns = {"/schedule/*","/ShowSchdule.html"})
public class AuthFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;
        HttpSession session = req.getSession();
        SysUser sysUser = (SysUser) session.getAttribute("sysUser");
        if(sysUser !=null){
            filterChain.doFilter(req,res);
        }else{
            res.sendRedirect("/login.html");
        }
    }

    @Override
    public void destroy() {

    }
}
