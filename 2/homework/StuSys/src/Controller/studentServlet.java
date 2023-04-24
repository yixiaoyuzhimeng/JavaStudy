package Controller;

import Dao.Dao;
import Model.Course;
import Model.Grades;
import Model.Stu;
import Model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/student/studentServlet")
public class studentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    Dao dao = new Dao();

    protected void service(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException
    {
        req.setCharacterEncoding("utf-8");
        String method = req.getParameter("method");
        if("updatestu".equals(method)) {
            updatestu(req,resp);
        }else if("liulankecheng".equals(method)) {
            liulankecheng(req,resp);
        }else if("liulankecheng1".equals(method)) {
            liulankecheng1(req,resp);
        }else if("checkGrades".equals(method)) {
            checkGrades(req,resp);
        }
    }

    private void liulankecheng(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        List<Course> cous = dao.liulankecheng();
        req.setAttribute("cous", cous);
        req.getRequestDispatcher("courseSelectionList.jsp").forward(req, resp);
    }

    private void updatestu(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String spid =(String) req.getSession().getAttribute("username1");
        String stuname = req.getParameter("stuname");
        String sex = req.getParameter("sex");
        String banji = req.getParameter("banji");
        String ye = req.getParameter("ye");
        String pwd = req.getParameter("password");

        Stu stu=new Stu(spid,stuname,sex,banji,ye);
        User user = new User(pwd);
        int res = dao.updatestu(stu, user);
        if(res == 0) {
            req.setAttribute("message","修改成功" );
            req.getRequestDispatcher("updateStudent.jsp").forward(req, resp);
        } else if(res == -1){
            req.setAttribute("message","修改失败" );
            req.getRequestDispatcher("updateStudent.jsp").forward(req, resp);
        }else if(res == 1){
            req.getRequestDispatcher("updateStudent.jsp").forward(req, resp);
        }
    }

    private void liulankecheng1(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        List<Course> cous = dao.liulankecheng1();
        req.setAttribute("cous", cous);
        req.getRequestDispatcher("courseList.jsp").forward(req, resp);

    }

    private void checkGrades(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("stuServelet.chhekGrades");

        req.setCharacterEncoding("utf-8");
        List<Grades> grade = dao.checkgrades();
        req.setAttribute("grade", grade);
        req.getRequestDispatcher("showGrades.jsp").forward(req, resp);

    }
}
