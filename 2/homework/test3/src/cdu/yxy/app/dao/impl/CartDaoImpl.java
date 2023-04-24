package cdu.yxy.app.dao.impl;
import cdu.yxy.app.dao.CartDao;
import cdu.yxy.app.model.CartItem;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
public class CartDaoImpl extends BaseDao implements CartDao {
    @Override
    public Map<Integer, Integer> find(int customerId) {
        Map<Integer,Integer> map=new HashMap<Integer, Integer>();
        String sql="SELECT * FROM cart_table WHERE customerId=?";
        try {
            pstmt=conn.prepareStatement(sql);
            pstmt.setInt(1,customerId);
            rs=pstmt.executeQuery();
            while(rs.next()){
                map.put(rs.getInt("productId"),rs.getInt("number"));
            }
        } catch (SQLException throwables) {
            System.out.println("CartDaoImpl未找到购物车 customerId="+customerId);
            throwables.printStackTrace();
        }
        return map;
    }
    @Override
    public int insert(CartItem cartItem) {
        int rows=0;
        String sql="INSERT INTO cart_table(customerId,productId,number)VALUES(?,?,?)";
        try {
            pstmt=conn.prepareStatement(sql);
            pstmt.setInt(1,cartItem.getCustomerId());
            pstmt.setInt(2,cartItem.getProductId());
            pstmt.setInt(3,cartItem.getProductNum());
            rows=pstmt.executeUpdate();
        } catch (SQLException throwables) {
            System.out.println("CartDaoImpl插入到购物车失败 "+cartItem);
            throwables.printStackTrace();
        }
        return rows;
    }
    @Override
    public int update(CartItem cartItem) {
        int rows=0;
        String sql="UPDATE cart_table SET number=? WHERE customerId=? AND productId=?";
        try {
            pstmt=conn.prepareStatement(sql);
            pstmt.setInt(1,cartItem.getProductNum());
            pstmt.setInt(2,cartItem.getCustomerId());
            pstmt.setInt(3,cartItem.getProductId());
            rows=pstmt.executeUpdate();
        } catch (SQLException throwables) {
            System.out.println("CartDaoImpl更新购物车失败 "+cartItem);
            throwables.printStackTrace();
        }
        return rows;
    }
    @Override
    public int delete(CartItem cartItem) {
        int rows=0;
        String sql="DELETE FROM cart_table WHERE customerId=? AND productId=?";
        try {
            pstmt=conn.prepareStatement(sql);
            pstmt.setInt(1,cartItem.getCustomerId());
            pstmt.setInt(2,cartItem.getProductId());
            rows=pstmt.executeUpdate();
        } catch (SQLException throwables) {
            System.out.println("CartDaoImpl删除失败"+cartItem);
            throwables.printStackTrace();
        }
        return rows;
    }
    @Override
    public int delete(int customerId) {
        int rows=0;
        String sql="DELETE FROM cart_table WHERE customerId=?";
        try {
            pstmt=conn.prepareStatement(sql);
            pstmt.setInt(1,customerId);
            rows=pstmt.executeUpdate();
        } catch (SQLException throwables) {
            System.out.println("CartDaoImpl删除失败"+customerId);
            throwables.printStackTrace();
        }
        return rows;
    }
}
