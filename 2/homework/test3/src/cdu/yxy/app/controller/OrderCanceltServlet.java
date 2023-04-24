package cdu.yxy.app.controller;
import cdu.yxy.app.service.OrderService;
import cdu.yxy.app.service.impl.OrderServiceImpl;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/orderCancel")
public class OrderCanceltServlet extends HttpServlet {
    OrderService orderService=new OrderServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String orderId=req.getParameter("orderId");
        boolean b=orderService.del(orderId);
        System.out.println(b);
        req.getRequestDispatcher("list.do").forward(req,resp);
    }
}
