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
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/cart")
public class CartServlet extends HttpServlet {
    ProductService productService=new ProductServiceImpl();
    CartService cartService=new CartServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session=req.getSession();
        Customer customer=(Customer) session.getAttribute("customer");
        if(customer==null){
            resp.sendRedirect("login.do");
            return;
        }
        Map<Integer,Integer> map=cartService.getProducts(customer.getId());
        Map<Integer, Product> productMap=new HashMap<>();
        Map<Integer,Integer> productNumMap=new HashMap<>();
        BigDecimal money=new BigDecimal(0);
        int i=0;
        for(int productId:map.keySet()){
            Product product=productService.get(productId);
            int buyNum=map.get(productId);
            productMap.put(++i,product);
            productNumMap.put(i,buyNum);
            money=money.add(product.getSalePrice().multiply(new BigDecimal(buyNum)));
        }
        session.setAttribute("products",map);
        session.setAttribute("productMap",productMap);
        session.setAttribute("productNumMap",productNumMap);
        session.setAttribute("cartMoney",money);
        req.getRequestDispatcher("cart.do").forward(req,resp);
    }
}
