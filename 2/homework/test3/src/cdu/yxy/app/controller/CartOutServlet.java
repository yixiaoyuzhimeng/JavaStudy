package cdu.yxy.app.controller;

import cdu.yxy.app.model.Customer;
import cdu.yxy.app.service.CartService;
import cdu.yxy.app.service.impl.CartServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/cartOut")
public class CartOutServlet extends HttpServlet {
    CartService cartService=new CartServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session=req.getSession();
        Customer customer=(Customer) session.getAttribute("customer");
        String sProductId=req.getParameter("productId");
        boolean a=cartService.out(customer.getId(),sProductId);
        System.out.println(a);
        resp.sendRedirect("cart");
    }
}
