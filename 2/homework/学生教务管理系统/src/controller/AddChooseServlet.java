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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/view/addChoose.do")
public class AddChooseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] IfChoose =  request.getParameterValues("IfChoose");
        PrintWriter out = response.getWriter();
        Service service = new ServiceImpl();
        response.setContentType("text/html;charset=utf-8");
        int flag = 0;
        for(int i=0;i<IfChoose.length;i++)
        {
            System.out.println(IfChoose[i]);
            Choose choose = new Choose();
            Student student = (Student)request.getSession().getAttribute("student");
            choose.setName(Integer.parseInt(IfChoose[i]));
            choose.setStudentId(student.getStudentId());
            if (service.add(choose)) {
                flag += 1;
            } else {
                flag += 0;
            }
        }
        if (IfChoose.length == flag) {
            out.println("<script>alert('选课成功');window.location.href='/view/courseList'</script>");
        } else {
            out.println("<script>alert('选课失败，请重新尝试');window.location.href='/view/courseList'</script>");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
