package servelet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.function.Consumer;

@WebServlet(urlPatterns = "/servlet5")
public class Servlet5 extends HttpServlet {


    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求的参数
        String userName = req.getParameter("userName");
        System.out.println(userName);
        String userPwd = req.getParameter("userPwd");
        System.out.println(userPwd);
        String[] hobbies = req.getParameterValues("hobby");
        if(hobbies.length>1){
            Arrays.stream(hobbies).forEach(s -> System.out.println(s));
        }else{
            System.out.println(userPwd);
        }
    }
}
