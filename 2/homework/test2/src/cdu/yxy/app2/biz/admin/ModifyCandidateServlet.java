package cdu.yxy.app2.biz.admin;

import cdu.yxy.app2.bean.Candidate;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Iterator;
import java.util.List;

@WebServlet("/admin/mod")
public class ModifyCandidateServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String url1=req.getParameter("url");
        if(url1==null || "".equals(url1)){
            resp.sendRedirect("modPre");
            return;
        }
        Candidate candidate=null;
        //    路径问题:如果我不修改，怎么做它才不会改变呢？？？ 怎么才能确定一张图片根本没有修改呢？
        //        创建和更改图片都是通过获取图片的名称


        //        配置保存位置
        String path="/photo";
        //        获取保存位置对应的真实物理地址
        String savedDir=req.getServletContext().getRealPath(path);
        //        创建一个基于磁盘文件系统的工厂类
        DiskFileItemFactory factory=new DiskFileItemFactory();
        //        创建文件上传器 核心组件
        ServletFileUpload upload =new ServletFileUpload(factory);
        try {
            //解析请求，获取所有items
            List<FileItem> items =upload.parseRequest(req);
            if (!items.isEmpty()){
                candidate=new Candidate();
            }
            //创建迭代器，准备处理表单数据
            Iterator<FileItem> iterator=items.iterator();
            while(iterator.hasNext()){
                FileItem item=iterator.next();
                //判断是普通表单域,还是上传的文件
                if(item.isFormField()){
                    //根据fieldName来判断是哪一个表单控件
                    if(item.getFieldName().equals("id")){
                        candidate.setId(Integer.parseInt(item.getString()));
                    }
//                    按理说管理员也不应该有这么大的权限修改数据
                    if(item.getFieldName().equals("votes")){
                        candidate.setVotes(Integer.parseInt(item.getString()));
                    }
                    if(item.getFieldName().equals("name")){
                        candidate.setName(new String(item.getString().getBytes("iso-8859-1"),"utf-8"));
                    }
                }else{
                    String fileName=item.getName();
                    System.out.println("获取更改的图片名称"+fileName);
                    System.out.println("获取更改的图片名称类型"+(fileName==""));
                    System.out.println(url1);
                    if(fileName!=""){
                        fileName=System.currentTimeMillis()+fileName;
                        File file=new File(savedDir+File.separator+fileName);
                        item.write(file);
                        candidate.setPhotoUrl(req.getContextPath()+path+"/"+fileName);
                    }else{
                        candidate.setPhotoUrl(url1);
                    }

                }
            }
            System.out.println("修改成功"+candidate);
        } catch (Exception e) {
            System.out.println("修改失败"+e.getMessage());
            e.printStackTrace();
        }
//        写入数据库
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out=resp.getWriter();
        if(candidate!=null){
            String driver="com.mysql.cj.jdbc.Driver";
            String url="jdbc:mysql://localhost:3306/mydb?serverTimezone=GMT";
            String db_user="root";
            String db_pwd="password";
            try {
                Class.forName(driver).newInstance();
                Connection conn= DriverManager.getConnection(url,db_user,db_pwd);
                String sql="update table_candidate set name=?,photoUrl=? where id=?";
                PreparedStatement pstmt=conn.prepareStatement(sql);
                pstmt.setString(1,candidate.getName());
                pstmt.setString(2,candidate.getPhotoUrl());
                pstmt.setInt(3,candidate.getId());
                int rows=pstmt.executeUpdate();
                if(rows==1){
                    System.out.println("修改成功");
                    out.println("<script>alert('候选人"+candidate.getName()+"修改成功');window.location.href='manage'</script>");
                }else{
                    System.out.println("修改失败");
                    out.println("<script>alert('候选人"+candidate.getName()+"修改失败');window.location.href='modPre?id="+candidate.getId()+"'</script>");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else{
            System.out.println("修改失败"+candidate);
            out.println("<script>alert('候选人"+candidate+"修改失败');window.location.href='modPre?id="+candidate.getId()+"'</script>");
        }
    }
}
