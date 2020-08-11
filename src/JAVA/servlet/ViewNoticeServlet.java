package JAVA.servlet;

import JAVA.bean.Notice;
import JAVA.service.realize.NoticeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@SuppressWarnings("all")
@WebServlet(name = "view", urlPatterns = {"/view"} )
public class ViewNoticeServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        NoticeService noticeService = new NoticeService();
        int start = 0;
        int count = 10;
        try {
            start = Integer.parseInt(req.getParameter("start"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        int next = start + count;
        int pre = start - count;
        int total = noticeService.total();
        int last;
        if (total % count == 0) {
            last = total - count;
        } else {
            last = total - total % count;
        }
        pre = Math.max(pre , 0);
        next = Math.min(next , last);
        req.setAttribute("pre" , pre);
        req.setAttribute("next" , next);
        req.setAttribute("last" , last);
        List<Notice> notices = noticeService.queryAll(start, count);
        req.setAttribute("notices" , notices);
        req.getRequestDispatcher("/viewnotice.jsp").forward(req , resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
