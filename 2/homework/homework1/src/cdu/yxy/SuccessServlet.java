package cdu.yxy;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/success")
public class SuccessServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        相应界面
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out=response.getWriter();
//          获取已登陆用户信息，session中保存的数据
        HttpSession session=request.getSession();
        String username=(String)session.getAttribute("username");

        out.println("<h1>欢迎你，"+username+"</h1>");
        out.println("<a href='logout'>注销</a>");
    }
}
