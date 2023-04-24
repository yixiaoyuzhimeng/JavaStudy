package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseDao {
    protected Connection conn = null;

    public BaseDao() {
        connect();
    }

    protected void connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/mydb?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone = GMT";
            String user = "root";
            String password = "001105";
            conn = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            System.out.println("数据库连接失败");
            e.printStackTrace();
        }
    }

    protected void close() {
        try {
            if (conn != null && !conn.isClosed()){
                conn.close();
            }
        }catch (SQLException e){
            System.out.println("关闭失败");
            e.printStackTrace();
        }
    }
}
