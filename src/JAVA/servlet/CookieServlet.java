package JAVA.servlet;

import JAVA.Dao.UserDao;
import JAVA.bean.User;
import JAVA.service.realize.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/cookie")
public class CookieServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        Cookie[] cks = req.getCookies();
        if (cks != null) {
            String cID = "";
            for (Cookie c:cks) {
                if ("cID".equals(c.getName())){
                    cID = c.getValue();
                }
            }
            if ("".equals(cID)) {
                resp.sendRedirect("index.jsp");
            }
            else {
                UserDao userDao = new UserDao();
                User user = userDao.queryID(Integer.parseInt(cID));
                if (user == null) {
                    req.getRequestDispatcher("login").forward(req, resp);
                }
                else {
                    UserService userService = new UserService();
                    User u = userService.checkLogin(user.getUsername(), user.getPassword());
                    if (u != null) {
                        req.getSession().setAttribute("User",u);
                        resp.sendRedirect("/home.jsp");
                    }
                    else {
                        resp.sendRedirect("/login.jsp");
                    }
                }
            }
        }
    }
}
