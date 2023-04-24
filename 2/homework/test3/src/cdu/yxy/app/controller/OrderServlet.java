package cdu.yxy.app.controller;
import cdu.yxy.app.model.Customer;
import cdu.yxy.app.model.Order;
import cdu.yxy.app.model.Product;
import cdu.yxy.app.service.CartService;
import cdu.yxy.app.service.OrderService;
import cdu.yxy.app.service.impl.CartServiceImpl;
import cdu.yxy.app.service.impl.OrderServiceImpl;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;
@WebServlet("/order")
public class OrderServlet extends HttpServlet {
    OrderService orderService=new OrderServiceImpl();
    CartService cartService=new CartServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session=req.getSession();
        Customer customer=(Customer) session.getAttribute("customer");
        Map<Integer,Integer> products=(Map<Integer,Integer>) session.getAttribute("products");
        Map<Integer, Product> productMap=(Map<Integer, Product>) session.getAttribute("productMap");
        Map<Integer,Integer> productNumMap=(Map<Integer, Integer>)session.getAttribute("productNumMap");
        BigDecimal cartMoney=(BigDecimal) session.getAttribute("cartMoney");
        String name=req.getParameter("name");
        String address=req.getParameter("address");
        String tel=req.getParameter("tel");
        long now =new Date().getTime();
        Order order=new Order();
        order.setOrderId(""+customer.getId()+now);
        order.setCustomer(customer);
        order.setMoney(cartMoney);
        order.setProducts(products);
        order.setName(name);
        order.setAddress(address);
        order.setTel(tel);
        order.setCreateTime(now);
        order.setUpdateTime(now);
        order.setStatusCode(0);
        if(orderService.createOrder(order)){
            session.removeAttribute("products");
            session.removeAttribute("productMap");
            session.removeAttribute("productNumMap");
            session.removeAttribute("cartMoney");
            req.setAttribute("order",order);
            req.getRequestDispatcher("pay.do?orderId="+order.getOrderId()).forward(req,resp);
        }else{
            resp.setContentType("text/html;charset=utf-8");
            PrintWriter out=resp.getWriter();
            out.println("<script>alert('提交订单失败');window.location.href='cart'</script>");
        }
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
