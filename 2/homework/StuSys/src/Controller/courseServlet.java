package Controller;

import Dao.Dao;
import Model.Course;
import Model.Stu;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/student/courseServlet")
public class courseServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    Dao dao = new Dao();

    protected void service(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException
    {
        req.setCharacterEncoding("utf-8");
        String method = req.getParameter("method");
        if("chakan".equals(method)) {
            chakan(req,resp);
        }else if("xuanke".equals(method)) {
            xuanke(req,resp);
        }
    }

    private void xuanke(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String spid =(String) req.getSession().getAttribute("username1");//这里的spid其实是用户姓名
        String cpid = req.getParameter("cpid");
        int snum = Integer.parseInt(req.getParameter("snum"))+1;
        String jiaoshi = req.getParameter("jiaoshi");
        int id =(int) req.getSession().getAttribute("id");
        String tpid=dao.searchtpid(jiaoshi);
        Stu stu = dao.searchstu(spid);

        System.out.println("xuanke_id:"+id);
        System.out.println("spid:"+stu.getSpid());
        System.out.println("cpid:"+cpid);
        System.out.println("tpid:"+tpid);
        System.out.println("stu:"+stu);

        int as = dao.addSelect(cpid,tpid,spid,stu);
        System.out.println("courseServlet_xuanke的执行情况1:"+as);

        if(as == 0)  {
            boolean uc = dao.updateCourse(id,snum);
            if(uc){//选课表更改成功再增加选课人数，否则不执行
                System.out.println("courseServlet_xuanke的执行情况2:"+uc);
                req.setAttribute("message","选课成功" );
                req.getRequestDispatcher("success.jsp").forward(req, resp);
            }else {
                req.setAttribute("message","错误！重复选课" );
                req.getRequestDispatcher("success.jsp").forward(req, resp);
            }
        }else if(as == 1) {
            req.setAttribute("message","错误！重复选课" );
            req.getRequestDispatcher("success.jsp").forward(req, resp);
        }else  if(as == 2){
            req.setAttribute("message","选课人数已满！" );
            req.getRequestDispatcher("success.jsp").forward(req, resp);
        }
    }

    private void chakan(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        int id = Integer.parseInt(req.getParameter("id"));
        Course cou = dao.searchByid(id);
        req.getSession().setAttribute("id", id);
        req.setAttribute("cou", cou);
        req.getRequestDispatcher("courseInformation.jsp").forward(req, resp);
    }
}
