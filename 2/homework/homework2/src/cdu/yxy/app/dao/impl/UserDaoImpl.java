package cdu.yxy.app.dao.impl;
import cdu.yxy.app.dao.BaseDao;
import cdu.yxy.app.dao.UserDao;
import cdu.yxy.app.model.User;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
//用户实体数据库访问接口的实现类
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
                user.setSex(rs.getString("sex"));
                user.setHobby(rs.getString("hobby"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return user;
    }

    @Override
    public List<User> findAll() {
        List<User> userList=new ArrayList<User>();
        String sql="SELECT * FROM user_table";
        try {
            stmt=conn.createStatement();
            rs=stmt.executeQuery(sql);
            while(rs.next()){
                User user=new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setPassword(rs.getString("password"));
                user.setSex(rs.getString("sex"));
                user.setHobby(rs.getString("hobby"));
                userList.add(user);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return userList;
    }

    @Override
    public List<User> findByPage(int start, int num) {
        List<User> userList=new ArrayList<User>();
        String sql="SELECT * FROM user_table ORDER BY id DESC LIMIT ?,?";
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
                user.setSex(rs.getString("sex"));
                user.setHobby(rs.getString("hobby"));
                userList.add(user);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return userList;
    }

    @Override
    public int insert(User user) {
        int rows=0;
        String sql="INSERT INTO user_table(name,password,sex,hobby) VALUE(?,?,?,?)";
        try {
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,user.getName());
            pstmt.setString(2,user.getPassword());
            pstmt.setString(3,user.getSex());
            pstmt.setString(4,user.getHobby());
            rows=pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rows;
    }

    @Override
    public int update(User user) {
        int rows=0;
        String sql="UPDATE user_table set name=?,password=?,sex=?,hobby=? WHERE id=?";
        try {
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,user.getName());
            pstmt.setString(2,user.getPassword());
            pstmt.setString(3,user.getSex());
            pstmt.setString(4,user.getHobby());
            pstmt.setInt(5,user.getId());
            rows=pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rows;
    }

    @Override
    public int delete(int id) {
        int rows=0;
        String sql="DELETE FROM user_table WHERE id=?";
        try {
            pstmt=conn.prepareStatement(sql);
            pstmt.setInt(1,id);
            rows=pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rows;
    }

    @Override
    public int count() {
        int count=0;
        String sql="SELECT count(*) from user_table";
        try {
            stmt=conn.createStatement();
            rs=stmt.executeQuery(sql);
            while(rs.next()){
                count=rs.getInt(1);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return count;
    }
}
