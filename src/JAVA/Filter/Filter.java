package JAVA.Filter;

import JAVA.bean.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Filter implements javax.servlet.Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpSession httpSession = req.getSession();
        servletRequest.setCharacterEncoding("utf-8");
        servletResponse.setContentType("text/html;charset=utf-8");
        String uri = req.getRequestURI();


        if( httpSession.getAttribute("User")== null && !uri.endsWith("login.jsp") && !uri.contains("Register") &&!uri.endsWith("register.jsp") && !uri.endsWith("index.jsp")&& !uri.endsWith("login") &&  !uri.endsWith(".css")&&!uri.endsWith(".js")&&!uri.endsWith(".jpg")&&!uri.contains("woff")&& !uri.contains("png") && !uri.contains("cookie") &&!uri.endsWith("8080")){
            PrintWriter out = resp.getWriter();
            out.write("<script>");
            out.write("alert('请您先登录！');");
            out.write("location.href='login.jsp';");
            out.write("</script>");
            out.close();
        }

        if (uri.startsWith("/user") || uri.startsWith("/text") || uri.startsWith("/writenotice.jsp")) {
            if (((User)httpSession.getAttribute("User")).getRig() == 1) {
                filterChain.doFilter(req, resp);
            }
            else {
                resp.sendRedirect("noRight.jsp");
            }
            return;
        }

        String ip = req.getRemoteAddr();
        String url = req.getRequestURI().toString();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date d=new Date();
        String date=sdf.format(d);
        System.out.printf("%s %s 访问了 %s%n",date,ip,url);
        filterChain.doFilter(req,resp);
    }
}
