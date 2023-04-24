package controller;

import model.Choose;
import service.Service;
import service.impl.ServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/view/mod")
public class ModServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        Choose choose = new Choose();
        choose.setId(Integer.parseInt(request.getParameter("id")));
        System.out.println(choose.getId());
        choose.setScore(Integer.parseInt(request.getParameter("name")));
        System.out.println(choose.getScore());
        PrintWriter out = response.getWriter();
        Service service = new ServiceImpl();
        if (service.mod(choose)) {
            out.println("<script>alert('修改成功');window.location.href='/view/teaScoreList'</script>");
        } else {
            out.println("<script>alert('修改失败，请重新尝试');window.location.href='/view/teaScoreList'</script>");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
