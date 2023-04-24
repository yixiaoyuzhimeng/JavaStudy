package cdu.yxy.app.controller;
import cdu.yxy.app.service.ProductService;
import cdu.yxy.app.service.impl.ProductServiceImpl;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/product/del")
public class DelProductServlet extends HttpServlet {
    ProductService productService=new ProductServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String sid=req.getParameter("id");
        boolean i=productService.del(sid);
        System.out.println(i);
        req.getRequestDispatcher("list").forward(req,resp);
    }
}
