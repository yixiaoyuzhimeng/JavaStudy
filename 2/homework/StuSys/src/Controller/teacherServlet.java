package Controller;

import Dao.Dao;
import Model.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/teacher/teacherServlet")
public class teacherServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    Dao dao = new Dao();

    protected void service(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException
    {
        req.setCharacterEncoding("utf-8");
        String method = req.getParameter("method");
        if("addcou".equals(method)) {
            addcou(req,resp);
        }else if("updatetea".equals(method)) {
            updatetea(req,resp);
        }else if("liulanstu".equals(method)) {
            liulanstu(req,resp);
        }else if("addgrades".equals(method)) {
            addgrades(req,resp);
        }

    }

    private void addcou(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String jiaoshi=(String) req.getSession().getAttribute("teaname");
        String cpid = req.getParameter("cpid");
        String cname = req.getParameter("cname");
        int num = Integer.parseInt(req.getParameter("num"));
        int snum=0;
        System.out.println(jiaoshi);
        Course cou=new Course(cpid,cname,num,snum,jiaoshi);
        if(dao.addCourse(cou)) {
            req.setAttribute("cou",cou);
            req.setAttribute("message","添加成功" );
            req.getRequestDispatcher("addCourse.jsp").forward(req, resp);
        }else {
            req.setAttribute("message","课程信息重复，请重新输入" );
            req.getRequestDispatcher("addCourse.jsp").forward(req, resp);
        }
    }

    private void liulanstu(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String tpid=(String) req.getSession().getAttribute("username");
        List<Select> jibens = dao.searchstuinfo(tpid);
        System.out.println("teacherSevlet.jibens:"+jibens);
        req.setAttribute("jibens",jibens);
        req.getRequestDispatcher("studentInformation.jsp").forward(req, resp);
    }

    private void updatetea(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String tpid=(String) req.getSession().getAttribute("username");
        String teaname = req.getParameter("teaname");
        String sex = req.getParameter("sex");
        String txueyuan = req.getParameter("txueyuan");
        String zhicheng = req.getParameter("zhicheng");
        String pwd = req.getParameter("password");
        Teacher teacher=new Teacher(tpid,teaname,sex,txueyuan,zhicheng);
        User user = new User(pwd);

        int res = dao.updatetea(teacher, user);
        if(res == 0) {
            req.setAttribute("message","修改成功" );
            req.getRequestDispatcher("updateTeacher.jsp").forward(req, resp);
        } else if(res == -1){
            req.setAttribute("message","修改失败" );
            req.getRequestDispatcher("updateTeacher.jsp").forward(req, resp);
        }else if(res == 1){
            req.getRequestDispatcher("updateTeacher.jsp").forward(req, resp);
        }

    }

    private void addgrades(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String tpid = null;
        String cpid = null;
        String course_name = null;
        String stu_name = null;
        int grades = 0;

        try {
            tpid=(String) req.getSession().getAttribute("username");
            System.out.println("teacherServlet.addgrades tpid:"+tpid);
            cpid = req.getParameter("cpid");
            course_name = req.getParameter("course_name");
            stu_name = req.getParameter("stu_name");
            grades = Integer.parseInt(req.getParameter("grades"));
        }catch (Exception e){
            req.setAttribute("message","输入格式错误！" );
            req.getRequestDispatcher("addGrades.jsp").forward(req, resp);
        }


        System.out.println("addGrades:"+cpid+course_name+stu_name+grades);

        Grades grades1 = new Grades(stu_name, course_name, grades, cpid);
        int res = dao.addGrades(grades1,tpid);

        if(res == 0) {
            req.setAttribute("grades1",grades1);
            req.setAttribute("message","录入成功" );
            req.getRequestDispatcher("addGrades.jsp").forward(req, resp);
        }else if(res == 1){
            req.setAttribute("message","学生与课程信息不符！" );
            req.getRequestDispatcher("addGrades.jsp").forward(req, resp);
        } else if(res == 2){
            req.setAttribute("message","成绩已存在，不可重复录入！" );
            req.getRequestDispatcher("addGrades.jsp").forward(req, resp);
        }else if(res == 3){
            req.setAttribute("message","您不是对应学生与课程的老师，无法录入该学生该课程的成绩！" );
            req.getRequestDispatcher("addGrades.jsp").forward(req, resp);
        }
    }
}

