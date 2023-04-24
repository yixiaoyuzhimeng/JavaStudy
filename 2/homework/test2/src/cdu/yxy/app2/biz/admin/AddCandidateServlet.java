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
import java.util.UUID;

@WebServlet( "/admin/add")
public class AddCandidateServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Candidate candidate = null;
//      文件上传
//      配置保存位置
        String path = "/photo";
//        获取保存位置对应的真实物理地址
        String savedDir = req.getServletContext().getRealPath(path);
//        创建一个基于磁盘文件系统的工厂类
        DiskFileItemFactory factory = new DiskFileItemFactory();
//        创建文件上传器
        ServletFileUpload upload = new ServletFileUpload(factory);
//        设置每一个item的头部字符编码，可以解决文件名的中文乱码问题
        upload.setHeaderEncoding("UTF-8");
        try {
            //解析请求
            List<FileItem> items = upload.parseRequest(req);
            if (!items.isEmpty()) {
                candidate = new Candidate();
            }
            //创建迭代器，准备处理表单数据
            Iterator<FileItem> iterator = items.iterator();
            while (iterator.hasNext()) {
                FileItem item = iterator.next();
//              判断是表单域,还是上传的文件
                if (item.isFormField()) {
//                    根据fieldName表单项名称，来判断是哪一个表单控件
                    if (item.getFieldName().equals("name")) {
                        candidate.setName(new String(item.getString().getBytes("iso-8859-1"), "utf-8"));
                    }
                }else {
//                      获取上传文件文件名
                    String fileName = item.getName();
                    fileName=System.currentTimeMillis()+fileName;
//                    //利用UUID生成伪随机字符串，作为文件名避免重复
//                    String uuid= UUID.randomUUID().toString();
//                    //获取文件后缀名
//                    String suffix=fileName.substring(fileName.lastIndexOf("."));
//                      保存文件
//                    File file = new File(savedDir + "//" + fileName);
                    File file=new File(savedDir+File.separator+fileName);
                    item.write(file);
                    candidate.setPhotoUrl(req.getContextPath()+path+"/"+fileName);
                }
            }
        } catch (Exception e) {
            System.out.println("上传文件出错" + e.getMessage());
            System.out.println(e);
        }
//返回响应
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
//      向数据库添加候选人
        if (candidate != null) {
            String driver = "com.mysql.cj.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3306/mydb?serverTimezone=GMT";
            String db_user = "root";
            String db_pwd = "password";
            try {
                Class.forName(driver).newInstance();
                Connection conn = DriverManager.getConnection(url, db_user, db_pwd);
                String sql = "insert into table_candidate(name,photoUrl) values(?,?)";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, candidate.getName());
                pstmt.setString(2, candidate.getPhotoUrl());
                int rows = pstmt.executeUpdate();
                if (rows == 1) {
                    System.out.println("添加成功" + candidate);
//                     路径问题 manage ? admin/manage ?/manage? 应该选第一个
                    out.println("<script>alert('候选人" + candidate.getName() +"添加成功');window.location.href='manage'</script>");
                } else {
                    System.out.println("添加失败" + candidate + "," + sql);
                    out.println("<script>alert('候选人" + candidate.getName() + "添加失败');window.location.href='addPre'</script>");
                }
            } catch (Exception e) {
                System.out.println("添加失败" + candidate + "," + e.getMessage());
                out.println("<script>alert('候选人" + candidate.getName() + "添加失败');window.location.href='addPre'</script>");
            }
        } else {
            System.out.println("添加失败" + candidate);
            out.println("<script>alert('候选人添加失败" + candidate.getName()+ "添加失败');window.location.href='addPre'</script>");//这里路径 TODO

        }
    }
}