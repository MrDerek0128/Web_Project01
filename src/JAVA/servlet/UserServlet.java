package JAVA.servlet;

import JAVA.Dao.UserDao;
import JAVA.bean.User;
import JAVA.service.realize.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@SuppressWarnings("all")
@WebServlet(name = "user",urlPatterns = {"/user"})
public class UserServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserService userService = new UserService();
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        int start = 0;
        int count = 10;
        try {
            start = Integer.parseInt(request.getParameter("start"));
        } catch (NumberFormatException e) {

        }
        int next = start + count;
        int pre = start - count;
        int total = userService.total();
        int last;
        if (0 == total % count)
            last = total - count;
        else
            last = total - total % count;
        pre = Math.max(pre, 0);
        next = Math.min(next, last);
        request.setAttribute("next", next);
        request.setAttribute("pre", pre);
        request.setAttribute("last", last);
        List<User> users = userService.queryAll(start, count);
        request.setAttribute("users", users);
        request.getRequestDispatcher("/user.jsp").forward(request, response);
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
