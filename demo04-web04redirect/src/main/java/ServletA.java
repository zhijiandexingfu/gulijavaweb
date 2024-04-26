import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/serveleta")
public class ServletA extends HttpServlet {


    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("serveleta 执行了");
        resp.sendRedirect("a.html");
//        RequestDispatcher requestDispatcher = req.getRequestDispatcher("web/WEB-INF/b.html");
//        requestDispatcher.forward(req, resp);
    }


}
