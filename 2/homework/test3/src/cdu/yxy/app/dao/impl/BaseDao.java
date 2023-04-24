package cdu.yxy.app.dao.impl;
import java.sql.*;
public class BaseDao {
    String driver="com.mysql.cj.jdbc.Driver";
    String url="jdbc:mysql://localhost:3306/mydb?serverTimezone=GMT";
    String jdbcUser="root";
    String jdbcPwd="password";
    protected Connection conn=null;
    protected Statement stmt=null;
    protected PreparedStatement pstmt=null;
    protected ResultSet rs=null;
    public BaseDao(){
        connect();
    }
    protected void connect(){
        try {
            Class.forName(driver).newInstance();
            conn=DriverManager.getConnection(url,jdbcUser,jdbcPwd);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
    protected  void close(){
        try {
            if(rs!=null &&!rs.isClosed()){
                rs.close();
            }
            if(stmt!=null &&!stmt.isClosed()){
                stmt.close();
            }
            if(pstmt!=null &&!pstmt.isClosed()){
                pstmt.close();
            }
            if(conn!=null &&!conn.isClosed()){
                conn.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
