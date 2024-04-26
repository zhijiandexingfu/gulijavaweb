package servelet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

public class Servlet1 extends HttpServlet {


    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("执行到了Servlet1了");
        ServletConfig servletConfig = getServletConfig();
        //直接打印参数a
        String vala = servletConfig.getInitParameter("keya");
        System.out.println(vala);
        //遍历
        Enumeration<String> initParameterNames = servletConfig.getInitParameterNames();
        while(initParameterNames.hasMoreElements()){
            String keyString = initParameterNames.nextElement();
            String vala2 = servletConfig.getInitParameter(keyString);
            System.out.println("key "+ keyString +   "是： " + vala2);

        }



    }
}
