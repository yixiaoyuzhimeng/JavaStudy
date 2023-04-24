package cdu.yxy.app.dao.impl;
import cdu.yxy.app.dao.UserDao;
import cdu.yxy.app.model.User;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class UserDaoImpl extends BaseDao implements UserDao {

    @Override
    public User get(int id) {
        User user=null;
        String sql="SELECT * FROM user_table WHERE id=?";
        try {
            pstmt=conn.prepareStatement(sql);
            pstmt.setInt(1,id);
            rs=pstmt.executeQuery();
            while(rs.next()){
                user=new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setPassword(rs.getString("password"));
                user.setIsAdmin(rs.getInt("isAdmin"));
            }
        } catch (SQLException throwables) {
            System.out.println("DAO获取用户失败id="+id);
            throwables.printStackTrace();
        }
        return user;
    }

    @Override
    public User get(String name, String password) {
        User user=null;
        String sql="SELECT * FROM user_table WHERE name=? AND password=?";
        try {
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,name);
            pstmt.setString(2,password);
            rs=pstmt.executeQuery();
            while(rs.next()){
                user=new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setPassword(rs.getString("password"));
                user.setIsAdmin(rs.getInt("isAdmin"));
            }
        } catch (SQLException throwables) {
            System.out.println("DAO获取用户失败name="+name+",password="+password);
            throwables.printStackTrace();
        }
        return user;
    }

    @Override
    public List<User> findAll() {
        List<User> userList=new ArrayList<>();
        String sql="SELECT * FROM user_table ORDER BY name";
        try {
            stmt=conn.createStatement();
            rs=stmt.executeQuery(sql);
            while(rs.next()){
                User user=new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setPassword(rs.getString("password"));
                user.setIsAdmin(rs.getInt("isAdmin"));
                userList.add(user);
            }
        } catch (SQLException throwables) {
            System.out.println("DAO获取用户列表失败");
            throwables.printStackTrace();
        }
        return userList;
    }

    @Override
    public List<User> findByPage(int start, int num) {
        List<User> userList=new ArrayList<>();
        String sql="SELECT * FROM user_table ORDER BY id LIMIT ?,?";
        try {
            pstmt=conn.prepareStatement(sql);
            pstmt.setInt(1,start);
            pstmt.setInt(2,num);
            rs=pstmt.executeQuery();
            while(rs.next()){
                User user=new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setPassword(rs.getString("password"));
                user.setIsAdmin(rs.getInt("isAdmin"));
                userList.add(user);
            }
        } catch (SQLException throwables) {
            System.out.println("DAO获取用户列表失败");
            throwables.printStackTrace();
        }
        return userList;
    }

    @Override
    public int count() {
        int count=0;
        String sql="SELECT count(*) FROM user_table";
        try {
            stmt=conn.createStatement();
            rs=stmt.executeQuery(sql);
            while(rs.next()){
                count=rs.getInt(1);
            }
        } catch (SQLException throwables) {
            System.out.println("Dao获取User数量失败");
            throwables.printStackTrace();
        }
        return count;
    }

    @Override
    public int insert(User user) {
        int rows=0;
        String sql="INSERT INTO user_table(name,password)Values(?,?)";
        try {
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,user.getName());
            pstmt.setString(2,user.getPassword());
            rows=pstmt.executeUpdate();
        } catch (SQLException throwables) {
            System.out.println("Dao插入User失败"+sql+","+user);
            throwables.printStackTrace();
        }
        return rows;
    }

    @Override
    public int update(User user) {
        int rows=0;
        String sql="INSERT INTO user_table SET name=?,password=?,isAdmin=? WHERE id=?";
        try {
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,user.getName());
            pstmt.setString(2,user.getPassword());
            pstmt.setInt(3,user.getIsAdmin()?1:0);
            pstmt.setInt(4,user.getId());
            rows=pstmt.executeUpdate();
        } catch (SQLException throwables) {
            System.out.println("Dao修改User失败"+sql+","+user);
            throwables.printStackTrace();
        }
        return rows;
    }

    @Override
    public int delete(int id) {
        int rows=0;
        String sql="DELETE FROM  user_table WHERE id=?";
        try {
            pstmt=conn.prepareStatement(sql);
            pstmt.setInt(1,id);
            rows=pstmt.executeUpdate();
        } catch (SQLException throwables) {
            System.out.println("Dao删除User失败"+sql+",id="+id);
            throwables.printStackTrace();
        }
        return rows;
    }
}
