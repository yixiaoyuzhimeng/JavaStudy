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
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@WebServlet( "/admin/manage")
public class ManageCandidateServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //从数据库中获取数据
        List<Candidate> candidateList=new ArrayList<Candidate>();
        String driver="com.mysql.cj.jdbc.Driver";
        String url="jdbc:mysql://localhost:3306/mydb?serverTimezone=GMT";
        String db_user="root";
        String db_pwd="password";
        try {
            Class.forName(driver).newInstance();
            Connection conn = DriverManager.getConnection(url,db_user,db_pwd);
            Statement stmt=conn.createStatement();
            String sql="select * from table_candidate order by votes";
            ResultSet rs=stmt.executeQuery(sql);
            while(rs.next()){
                Candidate candidate=new Candidate();
                candidate.setId(rs.getInt("id"));
                candidate.setName(rs.getString("name"));
                candidate.setPhotoUrl(rs.getString("photoUrl"));
                candidate.setVotes(rs.getInt("votes"));
                candidateList.add(candidate);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //显示管理页面
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out=resp.getWriter();
        out.println("<html><head><title>管理</title>");
        out.println("<link href='../css/style.css' type='text/css' rel='stylesheet'>");
        out.println("</head><body>");
        out.println("<h1>总人数："+candidateList.size()+"</h1>");
        out.println("<a href='addPre'>添加候选人</a><br>");
//        String base="http://"+req.getServerName()+":"+req.getServerPort();
        out.println("<table>");
        out.println("<tr>");
        out.println("<td>编号</td>");
        out.println("<td>姓名</td>");
        out.println("<td>票数</td>");
        out.println("<td>照片</td>");
        out.println("<td>修改</td>");
        out.println("<td>删除</td>");
        out.println("</tr>");
        for(int i=0;i<candidateList.size();i++){
            out.println("<tr>");
            out.println("<td>"+candidateList.get(i).getId()+"</td>");
            out.println("<td>"+candidateList.get(i).getName()+"</td>");
            out.println("<td>"+candidateList.get(i).getVotes()+"</td>");
//            图片的路径问题？
            out.println("<td><img src='"+candidateList.get(i).getPhotoUrl()+"'width='60' height='90'</td>");
            out.println("<td><a href='modPre?id="+candidateList.get(i).getId()+"'>修改</a></td>");
            out.println("<td><a href='del?id="+candidateList.get(i).getId()+"'>删除</a></td>");
            out.println("</tr>");
        }
        out.println("</table>");
        out.println("</body></html>");
        out.close();
    }
}
