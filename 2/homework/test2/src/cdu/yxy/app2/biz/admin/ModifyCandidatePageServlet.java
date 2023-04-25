package cdu.yxy.app2.biz.admin;
import cdu.yxy.app2.bean.Candidate;
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
import java.sql.ResultSet;
@WebServlet("/admin/modPre")
public class ModifyCandidatePageServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        获取修改候选人的id值
        String id=req.getParameter("id");
        if(id==null || "".equals(id)){
            resp.sendRedirect("manage");
            return;
        }
//        修改数据库（类似于list+add）
        Candidate candidate=null;
        String driver="com.mysql.cj.jdbc.Driver";
        String url="jdbc:mysql://localhost:3306/mydb?serverTimezone=GMT";
        String db_user="root";
        String db_pwd="password";
        try {
            Class.forName(driver).newInstance();
            Connection conn= DriverManager.getConnection(url,db_user,db_pwd);
            String sql="select * from table_candidate where id=?";
            PreparedStatement pstmt=conn.prepareStatement(sql);
            pstmt.setInt(1,Integer.parseInt(id));
            ResultSet rs=pstmt.executeQuery();
            while (rs.next()){
                candidate=new Candidate();
                candidate.setId(rs.getInt("id"));
                candidate.setName(rs.getString("name"));
                candidate.setPhotoUrl(rs.getString("photoUrl"));
                candidate.setVotes(rs.getInt("votes"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
//        显示到页面
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out =resp.getWriter();
        out.println("<html><head><title>修改候选人</title>");
        out.println("</head><body>");
        out.println("<form method='post' action='mod?url="+candidate.getPhotoUrl()+"' enctype='multipart/form-data'>");
        out.println("id：<input type='text' name='id' value='"+candidate.getId()+"' readonly><br>");
        out.println("选票：<input type='text' name='votes' value='"+candidate.getVotes()+"' readonly><br>");
        out.println("姓名：<input type='text' name='name' value='"+candidate.getName()+"' ><br>");
//        图片的路径问题？干脆直接在上面把这个候选人图片路径作为参数传过去，如果没有修改图片就直接用！嘎嘎嘎嘎改好啦！
        out.println("照片：<img src='"+candidate.getPhotoUrl()+"'><br>");
        out.println("id：<input type='file' name='photo' value='照片'><br>");
        out.println("<input type='submit' value='提交'><br>");
        out.println("</form></body></html>");
        out.close();
    }
}
