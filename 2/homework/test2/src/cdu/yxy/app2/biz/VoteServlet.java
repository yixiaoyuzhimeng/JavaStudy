package cdu.yxy.app2.biz;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
@WebServlet("/vote")
public class VoteServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        获取id
        String id=req.getParameter("id");
        if(id==null||"".equals(id)){
            resp.sendRedirect("admin/manage");
            return;
        }
//        修改数据库
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out=resp.getWriter();
        String driver="com.mysql.cj.jdbc.Driver";
        String url="jdbc:mysql://localhost:3306/mydb?serverTimezone=GMT";
        String db_user="root";
        String db_pwd="password";
        try{
            Class.forName(driver).newInstance();
            Connection conn = DriverManager.getConnection(url,db_user,db_pwd);
            String sql="update table_candidate set votes=votes+1 where id=?";
            PreparedStatement pstmt=conn.prepareStatement(sql);
            pstmt.setInt(1,Integer.parseInt(id));
            int rows =pstmt.executeUpdate();
            if(rows==1){
                System.out.println("投票成功"+id);
                out.println("<script>alert('您投给"+id+"号一票');window.location.href='list'</script>");
            }
            else{
                System.out.println("投票失败"+id+","+sql);
                out.println("<script>alert('您投票给"+id+"失败');window.location.href='list'</script>");
            }
        }catch(Exception e){
            System.out.println("投票给"+id+"失败,"+e.getMessage());
            out.println("<script>alert('错误"+id+"信息‘);window.location.href='list'</script>");
        }
    }
}
