package cdu.yxy.app;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ParamServlet extends HttpServlet {

    String paramServlet=null;
    String paramGlobal=null;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        paramServlet=config.getInitParameter("major");
        paramGlobal=config.getServletContext().getInitParameter("cdu");


    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out=resp.getWriter();
        out.println("局部初始化参数major="+paramServlet);
        out.println("\n全局初始化参数cdu="+paramGlobal);
    }
}
