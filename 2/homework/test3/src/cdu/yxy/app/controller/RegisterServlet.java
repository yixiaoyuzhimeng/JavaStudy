package cdu.yxy.app.controller;
import cdu.yxy.app.model.Customer;
import cdu.yxy.app.service.CustomerService;
import cdu.yxy.app.service.impl.CustomerServiceImpl;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    CustomerService customerService=new CustomerServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        Customer customer=new Customer();
        customer.setName(req.getParameter("name"));
        customer.setPassword(req.getParameter("password"));
        if(customerService.add(customer)){
            resp.sendRedirect("login.do");
        }else{
            resp.sendRedirect("list");
        }
    }
}
