package cdu.yxy.app2.biz.admin;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet("/admin/addPre")
public class AddCandidatePageServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        响应显示页面
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out =resp.getWriter();
        out.println("<html><head><title>增加候选人</title>");
        out.println("</head><body>");
//        路径问题 admin/add ？ add!后者!!!!!!why?想知道这个逻辑……
        out.println("<form method='post' action='add' enctype='multipart/form-data'>");
        out.println("候选人姓名<input type='text' name='name'><br>");
        out.println("候选人照片<input type='file' name='photo'><br>");
        out.println("<input type='submit' value='添加'><br>");
        out.println("</form></body></html>");
        out.close();
    }
}
