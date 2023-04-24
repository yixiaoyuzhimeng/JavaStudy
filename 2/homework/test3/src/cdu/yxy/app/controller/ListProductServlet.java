package cdu.yxy.app.controller;
import cdu.yxy.app.model.Product;
import cdu.yxy.app.service.ProductService;
import cdu.yxy.app.service.impl.ProductServiceImpl;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name="ListProductServlet",urlPatterns={"/list","/product/list"})
public class ListProductServlet extends HttpServlet {
    ProductService productService=new ProductServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String sPage=req.getParameter("page");
        int page=1;
        int pageSize=10;
        if(sPage!=null&&!sPage.equals("")){
            page=Integer.parseInt(sPage);
        }
        int count=productService.count();
        int pageCount=count%pageSize>0?count/pageSize+1:count/pageSize;
        List<Product> productList=productService.findByPage(page,pageSize);
        req.setAttribute("productList",productList);
        req.setAttribute("page",page);
        req.setAttribute("pageCount",pageCount);
        req.setAttribute("count",count);
        req.getRequestDispatcher("list.do").forward(req,resp);
    }
}
