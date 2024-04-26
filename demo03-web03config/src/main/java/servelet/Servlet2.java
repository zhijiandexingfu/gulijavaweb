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

@WebServlet(urlPatterns = "/servlet2", initParams = {@WebInitParam(name = "keya",value = "vala2"),@WebInitParam(name
= "keyb",value = "valb2" )})
public class Servlet2 extends HttpServlet {


    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("执行到了Servlet2了");
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

        //获取servletContext公共参数
        ServletContext servletContext = servletConfig.getServletContext();
        String valContext = servletContext.getInitParameter("encoding");
        System.out.println("context指定参数的val"+ valContext);
        //遍历
        Enumeration<String> initParameterNamesContext = servletContext.getInitParameterNames();
        while(initParameterNamesContext.hasMoreElements()){
            String keyContextString = initParameterNamesContext.nextElement();
            String valakeyContextString2 = servletContext.getInitParameter(keyContextString);
            System.out.println("keyContextString "+ keyContextString +   "是： " + valakeyContextString2);
        }
        //设置domin属性
        servletContext.setAttribute("key2","val2");
        servletContext.setAttribute("key2","val22222");
        servletContext.removeAttribute("key2");

    }
}
