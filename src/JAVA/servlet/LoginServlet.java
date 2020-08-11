package JAVA.servlet;

import JAVA.bean.User;
import JAVA.service.realize.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService userService = new UserService();
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset = UTF-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        User user = userService.checkLogin(username, password);
        if (user != null) {
            req.getSession().setAttribute("User",user);
            req.getSession().setAttribute("right",user.getRig());
            String check = req.getParameter("free");
            if (check != null && "yes".equals(check)){
                Cookie c = new Cookie("cID", user.getId()+"");
                c.setMaxAge(3*24*3600);
                c.setPath("/cookie");
                resp.addCookie(c);
                System.out.println("添加cookie");
            }
            resp.sendRedirect("/home.jsp");
        }
        else {
            PrintWriter out = resp.getWriter();
            out.write("<script>");
            out.write("alert('密码或用户名输入错误！');");
            out.write("location.href='login.jsp';");
            out.write("</script>");
            out.close();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }
}
