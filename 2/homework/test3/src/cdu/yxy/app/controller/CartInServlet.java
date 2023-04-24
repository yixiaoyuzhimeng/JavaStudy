package cdu.yxy.app.controller;

import cdu.yxy.app.model.Customer;
import cdu.yxy.app.model.Product;
import cdu.yxy.app.service.CartService;
import cdu.yxy.app.service.ProductService;
import cdu.yxy.app.service.impl.CartServiceImpl;
import cdu.yxy.app.service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

@WebServlet("/cartIn")
public class CartInServlet extends HttpServlet {
    CartService cartService=new CartServiceImpl();
    ProductService productService=new ProductServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session=req.getSession();
        Customer customer=(Customer) session.getAttribute("customer");
        if(customer==null){
            resp.sendRedirect("login.do");
            return;
        }
        String sProductId=req.getParameter("productId");
        if(sProductId==null||sProductId.equals("")){
            resp.sendRedirect("list");
            return;
        }
        int productId=Integer.parseInt(sProductId);

        Map<Integer,Integer> map=cartService.getProducts(customer.getId());
        if(map.containsKey(productId)){
            int buyNum=map.get(productId)+1;
            Product product=productService.get(productId);
            if(buyNum>product.getStock()){
                resp.setContentType("text/html;charset=utf-8");
                PrintWriter out=resp.getWriter();
                out.println("<script>alert('');windows.location.href='list'</script>");
                out.close();
            }else{
                cartService.update(customer.getId(),sProductId,buyNum);
            }
        }else{
            cartService.in(customer.getId(),sProductId);
        }
        resp.sendRedirect("list");
    }
}
