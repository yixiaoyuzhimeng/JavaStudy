package cdu.yxy.app.dao.impl;
import cdu.yxy.app.dao.CustomerDao;
import cdu.yxy.app.model.Customer;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class CustomerDaoImpl extends BaseDao implements CustomerDao {
    @Override
    public Customer get(int id) {
        Customer customer=null;
        String sql="SELECT * FROM customer_table WHERE id=?";
        try {
            pstmt=conn.prepareStatement(sql);
            pstmt.setInt(1,id);
            rs=pstmt.executeQuery();
            while(rs.next()){
                customer=new Customer();
                customer.setId(rs.getInt("id"));
                customer.setName(rs.getString("name"));
                customer.setPassword(rs.getString("password"));
                customer.setVip(rs.getBoolean("isVip"));
            }
        } catch (SQLException throwables) {
            System.out.println("DAO获取顾客失败 id="+id);
            throwables.printStackTrace();
        }
        return customer;
    }

    @Override
    public Customer get(String name, String password) {
        Customer customer=null;
        String sql="SELECT * FROM customer_table WHERE name=? AND password=?";
        try {
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,name);
            pstmt.setString(2,password);
            rs=pstmt.executeQuery();
            while(rs.next()){
                customer=new Customer();
                customer.setId(rs.getInt("id"));
                customer.setName(rs.getString("name"));
                customer.setPassword(rs.getString("password"));
                customer.setVip(rs.getBoolean("isVip"));
            }
        } catch (SQLException throwables) {
            System.out.println("DAO获取顾客失败 name="+name);
            throwables.printStackTrace();
        }
        return customer;
    }

    @Override
    public List<Customer> findAll() {
        List<Customer> customerList=new ArrayList<Customer>();
        String sql="SELECT * FROM customer_table ORDER BY name";
        try {
            stmt=conn.createStatement();
            rs=stmt.executeQuery(sql);
            while(rs.next()){
                Customer customer=new Customer();
                customer.setId(rs.getInt("id"));
                customer.setName(rs.getString("name"));
                customer.setPassword(rs.getString("password"));
                customer.setVip(rs.getBoolean("isVip"));
                customerList.add(customer);
            }
        } catch (SQLException throwables) {
            System.out.println("DAO 乘客findall失败");
            throwables.printStackTrace();
        }
        return customerList;
    }

    @Override
    public List<Customer> findByPage(int start, int num) {
        List<Customer> customerList=new ArrayList<Customer>();
        String sql="SELECT * FROM customer_table ORDER BY id LIMIT ?,?";
        try {
            pstmt=conn.prepareStatement(sql);
            pstmt.setInt(1,start);
            pstmt.setInt(2,num);
            rs=pstmt.executeQuery();
            while(rs.next()){
                Customer customer=new Customer();
                customer.setId(rs.getInt("id"));
                customer.setName(rs.getString("name"));
                customer.setPassword(rs.getString("password"));
                customer.setVip(rs.getBoolean("isVip"));
                customerList.add(customer);
            }
        } catch (SQLException throwables) {
            System.out.println("DAO 乘客Findbypage失败");
            throwables.printStackTrace();
        }
        return customerList;
    }

    @Override
    public List<Customer> findVip(boolean isVip) {
        List<Customer> customerList=new ArrayList<Customer>();
        String sql="SELECT * FROM customer_table WHERE isVip=";
        if(isVip){
            sql+="1";
        }else{
            sql+="0";
        }
        try {
            stmt=conn.createStatement();
            rs=stmt.executeQuery(sql);
            while(rs.next()){
                Customer customer=new Customer();
                customer.setId(rs.getInt("id"));
                customer.setName(rs.getString("name"));
                customer.setPassword(rs.getString("password"));
                customer.setVip(rs.getBoolean("isVip"));
                customerList.add(customer);
            }
        } catch (SQLException throwables) {
            System.out.println("DAO 乘客FindVip失败");
            throwables.printStackTrace();
        }
        return customerList;
    }

    @Override
    public int insert(Customer customer) {
        int rows=0;
        String sql="INSERT INTO customer_table(name,password) VALUES(?,?)";
        try {
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,customer.getName());
            pstmt.setString(2,customer.getPassword());
            rows=pstmt.executeUpdate();
           System.out.println("DAO插入顾客成功："+rows+","+customer);
        } catch (SQLException throwables) {
            System.out.println("DAO 插入乘客失败");
            throwables.printStackTrace();
        }
        return rows;
    }

    @Override
    public int update(Customer customer) {
        int rows=0;
        String sql="UPDATE customer_table SET name=?,password=?,isVip=? WHERE id=?";
        try {
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,customer.getName());
            pstmt.setString(2,customer.getPassword());
            pstmt.setBoolean(3,customer.isVip());
            pstmt.setInt(4,customer.getId());
            rows=pstmt.executeUpdate(sql);
            System.out.println("DAO修改顾客成功："+rows+","+customer);
        } catch (SQLException throwables) {
            System.out.println("DAO修改乘客失败");
            throwables.printStackTrace();
        }
        return rows;
    }

    @Override
    public int delete(int id) {
        int rows=0;
        String sql="DELETE FROM customer_table WHERE id=?";
        try {
            pstmt=conn.prepareStatement(sql);
            pstmt.setInt(1,id);
            rows=pstmt.executeUpdate(sql);
            System.out.println("DAO删除顾客成功："+rows+",id="+id);
        } catch (SQLException throwables) {
            System.out.println("DAO删除乘客失败");
            throwables.printStackTrace();
        }
        return rows;
    }

    @Override
    public int count() {
        int count=0;
        String sql="SELECT count(*) FROM customer_table";
        try {
            stmt=conn.createStatement();
            rs=stmt.executeQuery(sql);
            while(rs.next()){
                count=rs.getInt(1);
            }
        } catch (SQLException throwables) {
            System.out.println("DAO获取数量乘客失败");
            throwables.printStackTrace();
        }
        return count;
    }
}
