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

//@WebServlet(urlPatterns = "/servlet2", initParams = {@WebInitParam(name = "keya",value = "vala2"),@WebInitParam(name
//= "keyb",value = "valb2" )})
@WebServlet("/servelet2")
public class Servlet2 extends HttpServlet {


    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("servelet2 执行了");
    }
}
