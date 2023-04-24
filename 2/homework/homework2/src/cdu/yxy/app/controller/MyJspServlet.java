package cdu.yxy.app.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("*.do")
public class MyJspServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//       这是什么作用？？？
        String path=req.getRequestURI();
        System.out.println("path:"+path);
        String root=req.getContextPath();
        System.out.println("root:"+root);
        path=path.substring(root.length(),path.length()-3);
        System.out.println("path:"+path);
        path="/WEB-INF/jsp"+path+".jsp";
//        请求转发
        RequestDispatcher rd=req.getRequestDispatcher(path);
        rd.forward(req,resp);
    }
}
