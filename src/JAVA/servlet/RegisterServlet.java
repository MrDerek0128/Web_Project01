package JAVA.servlet;

import JAVA.bean.User;
import JAVA.service.realize.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService userService = new UserService();
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String name = req.getParameter("name");
        String sex = req.getParameter("sex");
        int age = Integer.parseInt(req.getParameter("age"));
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setName(name);
        user.setSex(sex);
        user.setAge(age);
        int t = userService.insert(user);
        PrintWriter out = resp.getWriter();
        if (t == 0) {
            out.write("<script>");
            out.write("alert('该用户名已存在！');");
            out.write("location.href='register.jsp';");
            out.write("</script>");
            out.close();
        }
        else {
            out.write("<script>");
            out.write("alert('注册成功！');");
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
