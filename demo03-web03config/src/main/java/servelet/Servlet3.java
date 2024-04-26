package servelet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet(urlPatterns = "/servlet3")
public class Servlet3 extends HttpServlet {


    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("执行到了Servlet3了");
        ServletContext servletContext = getServletContext();
        String uploadPath = servletContext.getRealPath("upload");
        System.out.println(uploadPath);
        //获得访问路径
        String contextPath = servletContext.getContextPath();
        System.out.println(contextPath);
        String attribute = (String)servletContext.getAttribute("key2");
        System.out.println(attribute);

    }
}
