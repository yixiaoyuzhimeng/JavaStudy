package cdu.yxy.app.controller;

import cdu.yxy.app.model.Product;
import cdu.yxy.app.service.ProductService;
import cdu.yxy.app.service.impl.ProductServiceImpl;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@WebServlet("/product/mod")
public class ModProductServlet extends HttpServlet {
    ProductService productService=new ProductServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String sid=req.getParameter("id");
        Product product=productService.get(sid);
        req.setAttribute("product",product);
        System.out.println("传过来的商品id号为：");
        System.out.println(sid);
        System.out.println("传过来的商品为：");
        System.out.println(product);
        req.getRequestDispatcher("mod.do").forward(req,resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        Product product=null;
        ProductService productService=new ProductServiceImpl();
//        此处路径容易出错
        String path="/productImg";
        String dir=getServletContext().getRealPath(path);
        DiskFileItemFactory factory=new DiskFileItemFactory();
        ServletFileUpload upload=new ServletFileUpload(factory);
        try {
            List<FileItem> fileItemList=upload.parseRequest(req);
            if(!fileItemList.isEmpty()){
                product=new Product();
            }
            Iterator<FileItem> iterator=fileItemList.iterator();
            while(iterator.hasNext()){
                FileItem item=iterator.next();
                if(item.isFormField()){
                    if(item.getFieldName().equals("id")){
                        product.setId(Integer.parseInt(item.getString()));
                    }
                    if(item.getFieldName().equals("name")){
                        product.setName(new String(item.getString().getBytes("ISO-8859-1"),"utf-8"));
                    }
                    if(item.getFieldName().equals("price")){
                        product.setPrice(new BigDecimal(item.getString()));
                    }
                    if(item.getFieldName().equals("sale")){
                        product.setSale(Integer.parseInt(item.getString()));
                    }
                    if(item.getFieldName().equals("stock")){
                        product.setStock(Integer.parseInt(item.getString()));
                    }
                    if(item.getFieldName().equals("info")){
                        product.setInfo(new String(item.getString().getBytes("ISO-8859-1"),"utf-8"));
                    }
                }else{
//                    String fileName=item.getName();
//                    fileName=""+new Date().getTime()+"_"+fileName;
//                    File file=new File(dir+"//"+fileName);
//                    item.write(file);
//                    product.setImgUrl(req.getContextPath()+path+"/"+fileName);
                    String filename=item.getName();
                    filename=""+new Date().getTime()+"_"+filename;
                    File file=new File(dir+"//"+filename);
                    item.write(file);
                    product.setImgUrl(req.getContextPath()+path+"/"+filename);
                }
            }
            product.setMarketDate(new Date().getTime());
            boolean i=productService.mod(product);
            System.out.println("修改成功？");
            System.out.println(i);
        } catch (FileUploadException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        resp.sendRedirect("list");
    }
}
