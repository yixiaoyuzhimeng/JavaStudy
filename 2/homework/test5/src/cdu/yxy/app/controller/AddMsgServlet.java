package cdu.yxy.app.controller;

import cdu.yxy.app.model.Msg;
import cdu.yxy.app.model.User;
import cdu.yxy.app.service.MsgService;
import cdu.yxy.app.service.impl.MsgServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/addMsg")
public class AddMsgServlet extends HttpServlet {
    MsgService msgService=new MsgServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("utf-8");
        HttpSession session=req.getSession();
        User user=(User) session.getAttribute("user");
        Msg msg=new Msg();
        msg.setUser(user);
        msg.setSubject(req.getParameter("subject"));
        msg.setContent(req.getParameter("content"));
        if(msgService.add(msg)){
            session.setAttribute("action","添加留言 "+msg.getSubject());
        }
        resp.sendRedirect("list");
    }
}
