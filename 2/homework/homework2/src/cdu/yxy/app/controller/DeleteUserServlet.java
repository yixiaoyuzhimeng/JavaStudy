package cdu.yxy.app.controller;

import cdu.yxy.app.service.UserService;
import cdu.yxy.app.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user/del")
public class DeleteUserServlet extends HttpServlet {
    UserService userService =new UserServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        userService.del(req.getParameter("id"));
        resp.sendRedirect("list");
    }
}
