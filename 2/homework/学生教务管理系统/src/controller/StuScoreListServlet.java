package controller;

import model.Choose;
import model.Student;
import service.Service;
import service.impl.ServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/view/stuScoreList")
public class StuScoreListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Student student = (Student)request.getSession().getAttribute("student");
        int studentId = student.getStudentId();
        System.out.println(studentId);
        response.setContentType("text/html;charset=utf-8");
        Service service = new ServiceImpl();
        List<Choose> chooseList = service.findChoose(studentId);
        request.setAttribute("chooseList", chooseList);
        request.getRequestDispatcher("scoreStu.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
