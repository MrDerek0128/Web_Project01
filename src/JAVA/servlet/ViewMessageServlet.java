package JAVA.servlet;

import JAVA.bean.Text;
import JAVA.service.realize.TextService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@SuppressWarnings("all")
@WebServlet(name = "text", urlPatterns = {"/text"} )
public class ViewMessageServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TextService textService = new TextService();
        int start = 0;
        int count = 10;
        try {
            start = Integer.parseInt(req.getParameter("start"));
        }catch (Exception e) {
            e.printStackTrace();
        }
        int next = start + count;
        int pre = start - count;
        int total = textService.total();
        int last;
        if (total % count == 0) {
            last = total - count;
        } else {
            last = total - total % count;
        }
        pre = Math.max(pre, 0);
        next = Math.min(next, last);
        req.setAttribute("pre", pre);
        req.setAttribute("last", last);
        req.setAttribute("next", next);
        List<Text> texts = textService.queryAll(start, count);
        req.setAttribute("texts", texts);
        req.getRequestDispatcher("/viewmessage.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
