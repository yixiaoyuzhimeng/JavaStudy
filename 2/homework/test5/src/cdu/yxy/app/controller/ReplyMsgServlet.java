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
import java.util.Date;

@WebServlet("/reply")
public class ReplyMsgServlet extends HttpServlet {
    MsgService msgService=new MsgServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String sid=req.getParameter("id");
        Msg msg=msgService.get(sid);

        req.setAttribute("msg",msg);

        req.getRequestDispatcher("reply.do").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        MsgService msgService=new MsgServiceImpl();

        HttpSession session=req.getSession();
        User user=(User) session.getAttribute("user");

        String sid=req.getParameter("id");
        if(sid==null||sid.equals("")){
            resp.sendRedirect("list");
        }

        Msg msg=new Msg();
        msg.setId(Integer.parseInt(sid));
        msg.setIsReplied(2);
        msg.setReUser(user);
        msg.setReply(req.getParameter("reply"));
        msg.setReTime(new Date().getTime());

        if(msgService.reply(msg)){
            session.setAttribute("action","回复留言："+msg.getReply());
        }

        resp.sendRedirect("list");
    }
}
