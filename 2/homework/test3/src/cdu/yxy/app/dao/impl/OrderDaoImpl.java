package cdu.yxy.app.dao.impl;
import cdu.yxy.app.dao.CustomerDao;
import cdu.yxy.app.dao.OrderDao;
import cdu.yxy.app.model.Order;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class OrderDaoImpl extends BaseDao implements OrderDao {
    CustomerDao customerDao=new CustomerDaoImpl();
    @Override
    public Order get(String orderId) {
        Order order=null;
        String sql="SELECT * FROM order_table WHERE orderId=?";
        try {
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,orderId);
            rs=pstmt.executeQuery();
            while(rs.next()){
                order=new Order();
                order.setId(rs.getInt("id"));
                order.setOrderId(rs.getString("orderId"));
                order.setCustomer(customerDao.get(rs.getInt("customerId")));
//                order.setCustomerId(rs.getInt("customerId"));
                order.setMoney(rs.getBigDecimal("money"));
                order.setProducts(rs.getString("products"));
                order.setName(rs.getString("name"));
                order.setAddress(rs.getString("address"));
                order.setTel(rs.getString("tel"));
                order.setCreateTime(rs.getLong("createTime"));
                order.setUpdateTime(rs.getLong("updateTime"));
                order.setStatusCode(rs.getInt("statusCode"));
            }
        } catch (SQLException throwables) {
            System.out.println("DAO订单获取失败:orderId="+orderId);
            throwables.printStackTrace();
        }
        return order;
    }

    @Override
    public List<Order> findAll() {
        List<Order> orderList=new ArrayList<Order>();
        String sql="SELECT * FROM order_table ORDER BY createTime DESC";
        try {
            stmt=conn.createStatement();
            rs=stmt.executeQuery(sql);
            while(rs.next()){
                Order order =new Order();
                order.setId(rs.getInt("id"));
                order.setOrderId(rs.getString("orderId"));
                order.setCustomer(customerDao.get(rs.getInt("customerId")));
//                order.setCustomerId(rs.getInt("customerId"));
                order.setMoney(rs.getBigDecimal("money"));
                order.setProducts(rs.getString("products"));
                order.setName(rs.getString("name"));
                order.setAddress(rs.getString("address"));
                order.setTel(rs.getString("tel"));
                order.setCreateTime(rs.getLong("createTime"));
                order.setUpdateTime(rs.getLong("updateTime"));
                order.setStatusCode(rs.getInt("statusCode"));
                orderList.add(order);
            }
        } catch (SQLException throwables) {
            System.out.println("DAO订单获取失败");
            throwables.printStackTrace();
        }
        return orderList;
    }

    @Override
    public List<Order> findByPage(int start, int num) {
        List<Order> orderList=new ArrayList<Order>();
        String sql="SELECT * FROM order_table ORDER BY createTime DESC LIMIT ?,?";
        try {
            pstmt=conn.prepareStatement(sql);
            pstmt.setInt(1,start);
            pstmt.setInt(2,num);
            rs=pstmt.executeQuery();
            while(rs.next()){
                Order order =new Order();
                order.setId(rs.getInt("id"));
                order.setOrderId(rs.getString("orderId"));
                order.setCustomer(customerDao.get(rs.getInt("customerId")));
//                order.setCustomerId(rs.getInt("customerId"));
                order.setMoney(rs.getBigDecimal("money"));
                order.setProducts(rs.getString("products"));
                order.setName(rs.getString("name"));
                order.setAddress(rs.getString("address"));
                order.setTel(rs.getString("tel"));
                order.setCreateTime(rs.getLong("createTime"));
                order.setUpdateTime(rs.getLong("updateTime"));
                order.setStatusCode(rs.getInt("statusCode"));
                orderList.add(order);
            }
        } catch (SQLException throwables) {
            System.out.println("DAO订单分页获取失败");
            throwables.printStackTrace();
        }
        return orderList;
    }

    @Override
    public List<Order> findByCustomer(int customerId) {
        List<Order> orderList=new ArrayList<Order>();
        String sql="SELECT * FROM order_table ORDER BY createTime DESC WHERE customerId=?";
        try {
            pstmt=conn.prepareStatement(sql);
            pstmt.setInt(1,customerId);
            rs=pstmt.executeQuery();
            while(rs.next()){
                Order order =new Order();
                order.setId(rs.getInt("id"));
                order.setOrderId(rs.getString("orderId"));
                order.setCustomer(customerDao.get(rs.getInt("customerId")));
//                order.setCustomerId(rs.getInt("customerId"));
                order.setMoney(rs.getBigDecimal("money"));
                order.setProducts(rs.getString("products"));
                order.setName(rs.getString("name"));
                order.setAddress(rs.getString("address"));
                order.setTel(rs.getString("tel"));
                order.setCreateTime(rs.getLong("createTime"));
                order.setUpdateTime(rs.getLong("updateTime"));
                order.setStatusCode(rs.getInt("statusCode"));
                orderList.add(order);
            }
        } catch (SQLException throwables) {
            System.out.println("DAO订单获取失败: customerId="+customerId);
            throwables.printStackTrace();
        }
        return orderList;
    }

    @Override
    public int insert(Order order) {
        int rows=0;
        String sql="INSERT INTO order_table(orderId,customerId,money,products,name,address,tel,createTime,updateTime,statusCode)VALUES(?,?,?,?,?,?,?,?,?,?)";
        try {
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,order.getOrderId());
            pstmt.setInt(2,order.getCustomer().getId());//这里保留疑问？TODO
            pstmt.setBigDecimal(3,order.getMoney());
            pstmt.setString(4,order.getProductsString());
            pstmt.setString(5,order.getName());
            pstmt.setString(6,order.getAddress());
            pstmt.setString(7,order.getTel());
            pstmt.setLong(8,order.getCreateTime());
            pstmt.setLong(9,order.getUpdateTime());
            pstmt.setInt(10,order.getStatusCode());
            rows=pstmt.executeUpdate();
            System.out.println("DAO订单插入成功:"+rows+","+order);
        } catch (SQLException throwables) {
            System.out.println("DAO订单插入失败");
            throwables.printStackTrace();
        }
        return rows;
    }

    @Override
    public int update(Order order) {
        int rows=0;
        String sql="UPDATE order_table SET updateTime=?,statusCode=? WHERE orderId=?";
        try {
            pstmt=conn.prepareStatement(sql);
            pstmt.setLong(1,order.getUpdateTime());
            pstmt.setInt(2,order.getStatusCode());
            pstmt.setString(3,order.getOrderId());
            rows=pstmt.executeUpdate();
            System.out.println("DAO订单修改成功:"+rows+","+order);
        } catch (SQLException throwables) {
            System.out.println("DAO订单修改失败");
            throwables.printStackTrace();
        }
        return rows;
    }

    @Override
    public int delete(String orderId) {
        int rows=0;
        String sql="DELETE FROM  order_table WHERE orderId=?";
        try {
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,orderId);
            rows=pstmt.executeUpdate();
            System.out.println("DAO订单删除成功:"+rows+",orderId="+orderId);
        } catch (SQLException throwables) {
            System.out.println("DAO订单删除失败");
            throwables.printStackTrace();
        }
        return rows;
    }

    @Override
    public int count() {
        int count=0;
        String sql="SELECT count(*) FROM order_table";
        try {
            stmt=conn.createStatement();
            rs=stmt.executeQuery(sql);
            while(rs.next()){
                count=rs.getInt(1);
            }
        } catch (SQLException throwables) {
            System.out.println("DAO获取总数失败");
            throwables.printStackTrace();
        }
        return count;
    }
}
