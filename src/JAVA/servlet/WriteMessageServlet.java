package JAVA.servlet;

import JAVA.bean.Text;
import JAVA.bean.User;
import JAVA.service.realize.TextService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/write")
public class WriteMessageServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TextService textService = new TextService();
        Text text = new Text();
        String topic = req.getParameter("topic");
        String content = req.getParameter("content");
        text.setTopic(topic);
        text.setContent(content);
        text.setWriter(((User)req.getSession().getAttribute("User")).getUsername());
        int t = textService.insert(text);
        PrintWriter out = resp.getWriter();
        if (t == 0) {
            out.write("<script>");
            out.write("alert('留言失败！');");
            out.write("location.href='writemessage.jsp';");
            out.write("</script>");
            out.close();
        } else {
            out.write("<script>");
            out.write("alert('留言成功！');");
            out.write("location.href='home.jsp';");
            out.write("</script>");
            out.close();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
