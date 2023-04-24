package controller;

import model.Student;
import service.Service;
import service.impl.ServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/view/addStudent.do")
public class AddStudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("utf-8");
        Student student = new Student();
        student.setStudentId(Integer.getInteger(request.getParameter("studentId")));
        student.setStudentName(request.getParameter("studentName"));
        student.setStudentPwd(request.getParameter("studentPwd"));
        student.setStudentSex(request.getParameter("studentSex"));
        student.setStudentAge(request.getParameter("studentAge"));
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        Service service = new ServiceImpl();
        if (service.add(student)) {
            out.println("<script>alert('创建成功');window.location.href=''</script>");
        } else {
            out.println("<script>alert('创建失败');window.location.href=''</script>");
        }
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
