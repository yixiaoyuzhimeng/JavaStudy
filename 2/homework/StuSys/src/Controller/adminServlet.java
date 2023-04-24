package Controller;


import Dao.Dao;
import Model.Stu;
import Model.Teacher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/adminServlet")
public class adminServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    Dao dao = new Dao();

    protected void service(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException
    {
        req.setCharacterEncoding("utf-8");
        String method = req.getParameter("method");
        if("addtea".equals(method)) {
            addtea(req,resp);
        }else if("addstu".equals(method)) {
            addstu(req,resp);
        }
    }

    private void addtea(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String tpid = req.getParameter("tpid");
        String teaname = req.getParameter("teaname");
        String sex = req.getParameter("sex");
        String txueyuan = req.getParameter("txueyuan");
        String zhicheng = req.getParameter("zhicheng");
        int pid=1;
        String password = "123456";
        Teacher teacher=new Teacher(tpid,teaname,sex,txueyuan,zhicheng);
        if(dao.addtea(teacher)&&dao.adduser(tpid,password,pid)) {
            req.setAttribute("teacher",teacher);
            req.setAttribute("message","添加成功" );
            req.getRequestDispatcher("addTeacher.jsp").forward(req, resp);
        }else {
            req.setAttribute("message","老师姓名重复，请重新输入" );
            req.getRequestDispatcher("addTeacher.jsp").forward(req, resp);
        }
    }

    private void addstu(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String spid = req.getParameter("spid");
        String stuname = req.getParameter("stuname");
        String sex = req.getParameter("sex");
        String banji = req.getParameter("banji");
        String ye = req.getParameter("ye");
        Stu stu=new Stu(spid,stuname,sex,banji,ye);
        int pid=2;
        String password="123456";
        if(dao.addstu(stu)&&dao.adduser(spid, password, pid)) {
            req.setAttribute("stu",stu);
            req.setAttribute("message","添加成功" );
            req.getRequestDispatcher("addStu.jsp").forward(req, resp);
        }else {
            req.setAttribute("message","学生姓名重复，请重新输入" );
            req.getRequestDispatcher("addStu.jsp").forward(req, resp);
        }
    }
}
