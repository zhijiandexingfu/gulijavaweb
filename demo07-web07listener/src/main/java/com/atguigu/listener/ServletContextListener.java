package com.atguigu.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.annotation.WebListener;

@WebListener
public class ServletContextListener implements javax.servlet.ServletContextListener, ServletContextAttributeListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println(servletContextEvent.getServletContext().hashCode() + " 监听到application context 已经创建");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println(servletContextEvent.getServletContext().hashCode() + " 监听到application context 已经销毁");

    }

    @Override
    public void attributeAdded(ServletContextAttributeEvent servletContextAttributeEvent) {
        String name = servletContextAttributeEvent.getName();
        Object value = servletContextAttributeEvent.getValue();
        System.out.println(servletContextAttributeEvent.getServletContext().hashCode() +" 监听到application context的属性已经增加" + "name是:" + name + "val是:" + value);
    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent servletContextAttributeEvent) {
        String name = servletContextAttributeEvent.getName();
        Object value = servletContextAttributeEvent.getValue();
        System.out.println(servletContextAttributeEvent.getServletContext().hashCode() +" 监听到application context的属性:" + name + " 已经删除");
    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent servletContextAttributeEvent) {
        String name = servletContextAttributeEvent.getName();
        Object value = servletContextAttributeEvent.getValue();
        Object newAttr = servletContextAttributeEvent.getServletContext().getAttribute(name);
        System.out.println(servletContextAttributeEvent.getServletContext().hashCode() +" 监听到application context的属性:" + name + "old val" + value +
                " 已经被替换成:" + newAttr);
    }
}
