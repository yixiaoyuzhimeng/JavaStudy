package cdu.yxy.app.dao;
import java.sql.*;
//数据库连接基类
public class BaseDao {
    String driver="com.mysql.cj.jdbc.Driver";
    String url="jdbc:mysql://localhost:3306/mydb?serverTimezone=Asia/Shanghai";
    String jdbcUser="root";
    String jdbcPwd="password";
    protected Connection conn=null;
    protected Statement stmt=null;
    protected PreparedStatement pstmt=null;
    protected ResultSet rs=null;
    public BaseDao(){
        connet();
    }
    void connet() {
        try {
            Class.forName(driver).newInstance();
            conn=DriverManager.getConnection(url,jdbcUser,jdbcPwd);
        } catch (Exception e) {
            System.out.println("数据库连接失败");
            e.printStackTrace();
        }
    }
    void close(){
        try {
            if(rs!=null && !rs.isClosed()){
                rs.close();
            }
            if(stmt!=null && !stmt.isClosed()){
                stmt.close();
            }
            if(pstmt!=null &&!pstmt.isClosed()){
                pstmt.close();
            }
            if(conn!=null && !conn.isClosed()){
                conn.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
