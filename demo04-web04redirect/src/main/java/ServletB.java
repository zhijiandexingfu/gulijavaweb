import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebServlet(urlPatterns = "/servlet2", initParams = {@WebInitParam(name = "keya",value = "vala2"),@WebInitParam(name
//= "keyb",value = "valb2" )})
@WebServlet("/serveletb")
public class ServletB extends HttpServlet {


    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("serveletb 执行了");
    }
}
