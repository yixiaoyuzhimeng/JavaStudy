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
import java.io.Writer;
import java.util.List;

@WebServlet("/view/courseList")
public class CourseListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sPage = request.getParameter("page");
        int page = (sPage == null || sPage.equals(""))?1:Integer.parseInt(sPage);
        int pageSize = 10;
        response.setContentType("text/html;charset=utf-8");
        String role = (String) request.getSession().getAttribute("role");
        request.setAttribute("page", page);
        request.setAttribute("pageSize", pageSize);
        Service service = new ServiceImpl();
        List<Course> courseList = service.findByPage(page, pageSize);
        request.setAttribute("courseList", courseList);
        String sql = "select count(*) from course";
        int courseLCount = service.getCount(sql);
        request.setAttribute("courseCount", courseLCount);
        PrintWriter out = response.getWriter();
        request.setAttribute("pageCount", courseLCount % pageSize == 0?courseLCount/pageSize:courseLCount/pageSize+1);
        System.out.println(role);
        if (role.equals("teacher") && role != null && !role.equals("")) {
            request.getRequestDispatcher("CourseList.jsp").forward(request, response);
        } else if (role.equals("student") && role != null && !role.equals("")){
            request.getRequestDispatcher("chooseCourse.jsp").forward(request, response);
        } else {
            out.println("<script>alert('有问题');window.location.href='/view/login.jsp'</script>");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
