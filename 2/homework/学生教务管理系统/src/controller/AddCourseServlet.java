package controller;

import model.Course;
import service.Service;
import service.impl.ServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/view/addCourse.do")
public class AddCourseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        Course course = new Course();
        course.setCourseId(Integer.parseInt(request.getParameter("courseId")));
        course.setCourseName(request.getParameter("courseName"));
        course.setTeacherName(request.getParameter("teacherName"));
        response.setContentType("text/html;charset;charset=utf-8");
        PrintWriter out = response.getWriter();
        Service service = new ServiceImpl();
        if (service.add(course)) {
            out.println("<script>alert('课程添加成功');window.location.href='/view/courseList'</script>");
        } else {
            out.println("<script>alert('课程添加失败');window.location.href='/view/courseList'</script>");
        }
        out.close();
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
