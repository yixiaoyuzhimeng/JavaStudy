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

@WebServlet("/view/del.do")
public class DelCourseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] names = request.getParameterValues("IfDel");
        Service service = new ServiceImpl();
        int flag = 0;
        for (int i=0;i<names.length;i++) {
            if (service.delete(Integer.parseInt(names[i]))) {
                flag += 1;
            } else {
                flag += 0;
            }
        }
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        if (names.length == flag) {
            out.println("<script>alert('删除课程成功');window.location.href='/view/courseList'</script>");
        } else {
            out.println("<script>alert('删除课程失败');window.location.href='/view/courseList'</script>");
        }
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
