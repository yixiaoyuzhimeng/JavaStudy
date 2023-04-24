package controller;

import service.Service;
import service.impl.ServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/view/delChoose")
public class DelChooseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] id = request.getParameterValues("IfDel");
        Service service = new ServiceImpl();
        int flag = 0;
        for (int i=0;i<id.length;i++) {
            System.out.println(Integer.parseInt(id[i]));
            if (service.deleteCh(Integer.parseInt(id[i]))) {
                flag += 1;
            } else {
                flag += 0;
            }
        }
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        if (id.length == flag) {
            out.println("<script>alert('删除选课信息成功');window.location.href='/view/teaScoreList'</script>");
        } else {
            out.println("<script>alert('删除选课信息失败');window.location.href='/view/teaScoreList'</script>");
        }
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
