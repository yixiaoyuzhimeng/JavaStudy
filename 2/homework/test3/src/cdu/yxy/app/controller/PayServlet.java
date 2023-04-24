package cdu.yxy.app.controller;
import cdu.yxy.app.model.Order;
import cdu.yxy.app.service.OrderService;
import cdu.yxy.app.service.impl.OrderServiceImpl;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
@WebServlet("/pay")
public class PayServlet extends HttpServlet {
    OrderService orderService=new OrderServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String orderId=req.getParameter("orderId");
        Order order=orderService.get(orderId);
        order.setStatusCode(1);
        order.setUpdateTime(new Date().getTime());
        orderService.updateStatus(order);
        req.setAttribute("order",order);
        req.getRequestDispatcher("pay.do?orderId="+orderId).forward(req,resp);
    }
}
