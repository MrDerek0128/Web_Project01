package JAVA.servlet;

import JAVA.bean.Notice;
import JAVA.service.realize.NoticeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "notice", urlPatterns = {"/notice"} )
public class WriteNoticeServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        NoticeService noticeService = new NoticeService();
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        Date time = new Date(System.currentTimeMillis());
        Notice notice = new Notice();
        String topic = req.getParameter("topic");
        String content = req.getParameter("content");
        String date = formatter.format(time);
        notice.setTopic(topic);
        notice.setContent(content);
        notice.setDate(date);
        int t = noticeService.insert(notice);
        PrintWriter out = resp.getWriter();
        if (t == 0) {
            out.write("<script>");
            out.write("alert('发布失败！');");
            out.write("location.href='writenotice.jsp';");
            out.write("</script>");
            out.close();
        } else {
            out.write("<script>");
            out.write("alert('发布成功！');");
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
