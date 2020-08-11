package JAVA.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/loginOut")
public class LoginOutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("out") != null){
            Cookie newCookie = new Cookie("cID", null);
            newCookie.setMaxAge(0);
            newCookie.setPath("/cookie");
            resp.addCookie(newCookie);
            System.out.println(newCookie);
            req.getSession(false).invalidate();
            resp.sendRedirect("login.jsp");
        }
    }
}
