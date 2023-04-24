package Controller;

import Dao.Dao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    Dao dao = new Dao();

    protected void service(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException
    {
        req.setCharacterEncoding("utf-8");
        String method = req.getParameter("method");
        if("login".equals(method)) {
            login(req,resp);
        }
    }

    private void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        req.setCharacterEncoding("utf-8");
        String username = req.getParameter("username");
        String password=req.getParameter("password");
        int pid = dao.searchPid(username,password);
        req.setAttribute("pid", pid);

        System.out.println(pid);
        if(pid==1) {
            String teaname=dao.searchteaname(username);
            System.out.println(teaname);
            req.getSession().setAttribute("username", username);
            req.getSession().setAttribute("teaname", teaname);
            req.getRequestDispatcher(pid+".jsp").forward(req, resp);
        }
        else if(pid==2) {
            req.getSession().setAttribute("username1", username);
            req.getRequestDispatcher(pid+".jsp").forward(req, resp);
        }else if(pid==3) {
            req.getRequestDispatcher(pid+".jsp").forward(req, resp);
        }else {
            req.setAttribute("message","登录失败！用户不存在或密码错误" );
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }

    }

}
