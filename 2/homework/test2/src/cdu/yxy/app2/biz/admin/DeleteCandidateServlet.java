package cdu.yxy.app2.biz.admin;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
@WebServlet("/admin/del")
public class DeleteCandidateServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取id参数
        String id=req.getParameter("id");
        if(id==null||"".equals(id)){
            resp.sendRedirect("manage");
            return;
        }
        //读取数据库并执行删除操作
        String driver ="com.mysql.cj.jdbc.Driver";
        String url="jdbc:mysql://localhost:3306/mydb?serverTimezone=GMT";
        String db_user="root";
        String db_pwd="password";
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out =resp.getWriter();
        try {
            Class.forName(driver).newInstance();
            Connection conn= DriverManager.getConnection(url,db_user,db_pwd);
            Statement stmt=conn.createStatement();
            String sql="delete from table_candidate where id ='"+id+"'";
            int rows=stmt.executeUpdate(sql);
            if(rows==1){
                System.out.println("删除成功"+id);
                out.println("<script>alert('候选人" +id +"号已删除');window.location.href='manage'</script>");
            }else{
                System.out.println("删除失败"+sql);
                out.println("<script>alert('删除id"+id+"号失败"+sql+"');window.location.href='manage'</script>");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
