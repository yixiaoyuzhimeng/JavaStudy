package controller;

import model.Student;
import model.Teacher;
import service.Service;
import service.impl.ServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String role = request.getParameter("role");
        Integer name = Integer.parseInt(request.getParameter("name"));
        String password = request.getParameter("password");
        String inputCode = request.getParameter("inputCode");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        session.setAttribute("role", role);
        // 失败情况下跳转回原页面
        String validCode = (String) session.getAttribute("validCode");
        if (validCode == null || validCode.equals("inputCode") || !validCode.equals(inputCode)) {
            out.println("<script>alert('验证码有误，请重新尝试');window.location.href='/view/login.jsp'</script>");
            return;
        }
        if (name == null || password == null || name.equals("") || password.equals("") || role == null || role.equals("")) {
            out.println("<script>alert('账户或密码有误，请重新尝试');window.location.href='/view/login.jsp'</script>");
            return;
        }
        Service service = new ServiceImpl();
        // Course course = service.getCou()
        if (role.equals("student")) {
            Student student = service.checkLoginStu(name, password);
            if (student != null) {
                out.println("<script>alert('登录成功');window.location.href='view/studentIndex.jsp'</script>");
                // request.getRequestDispatcher("/view/studentIndex.jsp").forward(request, response);
                session.setAttribute("student", student);
            } else {
                out.println("<script>alert('账户或密码有误，请重新尝试');window.location.href='/view/login.jsp'</script>");
            }
        } else if (role.equals("teacher")) {
            Teacher teacher = service.checkLoginTea(name, password);
            if (teacher != null) {
                out.println("<script>alert('登录成功');window.location.href='/view/teacherIndex.jsp'</script>");
                // request.getRequestDispatcher("").forward(request, response);
                session.setAttribute("teacher", teacher);
            } else {
                out.println("<script>alert('账户或密码有误，请重新尝试');window.location.href='/view/login.jsp'</script>");
            }
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
