package cdu.yxy.app.controller;

import cdu.yxy.app.model.Customer;
import cdu.yxy.app.service.CustomerService;
import cdu.yxy.app.service.impl.CustomerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    CustomerService customerService=new CustomerServiceImpl();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String name=req.getParameter("name");
        String password=req.getParameter("password");
        HttpSession session=req.getSession();
        Customer customer=customerService.get(name,password);
        if(customer!=null){
            session.setAttribute("customer",customer);
        }
        resp.sendRedirect("list");
//        有一部分注释掉了
    }
}
