package cdu.yxy.app.controller;

import cdu.yxy.app.service.MsgService;
import cdu.yxy.app.service.impl.MsgServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delMsg")
public class DelMsgServlet extends HttpServlet {
    MsgService msgService=new MsgServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String sid=req.getParameter("id");
        if(msgService.del(sid)){
            req.getSession().setAttribute("action","删除留言 msg.id="+sid);
        }
        resp.sendRedirect("list");
    }
}
