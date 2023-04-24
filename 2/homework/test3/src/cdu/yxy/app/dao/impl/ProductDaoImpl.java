package cdu.yxy.app.dao.impl;
import cdu.yxy.app.dao.ProductDao;
import cdu.yxy.app.model.Product;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class ProductDaoImpl extends BaseDao implements ProductDao {
    @Override
    public Product get(int id) {
        Product product=null;
        String sql="SELECT * FROM product_table WHERE id=?";
        try {
            pstmt=conn.prepareStatement(sql);
            pstmt.setInt(1,id);
            rs=pstmt.executeQuery();
            while(rs.next()){
                product=new Product();
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                product.setPrice(rs.getBigDecimal("price"));
                product.setSale(rs.getInt("sale"));
                product.setStock(rs.getLong("stock"));
                product.setMarketDate(rs.getLong("marketDate"));
                product.setImgUrl(rs.getString("imgUrl"));
                product.setInfo(rs.getString("info"));
            }
        } catch (SQLException throwables) {
            System.out.println("DAO获取商品失败 id="+id);
            throwables.printStackTrace();
        }
        return product;
    }

    @Override
    public List<Product> findAll() {
        List<Product> productList =new ArrayList<Product>();
        String sql="SELECT * FROM product_table ORDER BY name";
        try {
            stmt=conn.createStatement();
            rs=pstmt.executeQuery(sql);
            while(rs.next()){
                Product product=new Product();
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                product.setPrice(rs.getBigDecimal("price"));
                product.setSale(rs.getInt("sale"));
                product.setStock(rs.getLong("stock"));
                product.setMarketDate(rs.getLong("marketDate"));
                product.setImgUrl(rs.getString("imgUrl"));
                product.setInfo(rs.getString("info"));
                productList.add(product);
            }
        } catch (SQLException throwables) {
            System.out.println("DAO获取全部商品失败");
            throwables.printStackTrace();
        }
        return productList;
    }

    @Override
    public List<Product> findByPage(int start,int num) {
        List<Product> productList =new ArrayList<Product>();
        String sql="SELECT * FROM product_table ORDER BY name LIMIT ?,?";
        try {
            pstmt=conn.prepareStatement(sql);
            pstmt.setInt(1,start);
            pstmt.setInt(2,num);
            rs=pstmt.executeQuery();
            while(rs.next()){
                Product product=new Product();
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                product.setPrice(rs.getBigDecimal("price"));
                product.setSale(rs.getInt("sale"));
                product.setStock(rs.getLong("stock"));
                product.setMarketDate(rs.getLong("marketDate"));
                product.setImgUrl(rs.getString("imgUrl"));
                product.setInfo(rs.getString("info"));
                productList.add(product);
            }
        } catch (SQLException throwables) {
            System.out.println("DAO获取部分商品失败");
            throwables.printStackTrace();
        }
        return productList;
    }

    @Override
    public int insert(Product product) {
        int rows=0;
        String sql="INSERT INTO product_table(name,price,sale,stock,marketDate,imgUrl,info) VALUES(?,?,?,?,?,?,?)";
        try {
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,product.getName());
            pstmt.setBigDecimal(2,product.getPrice());
            pstmt.setInt(3,product.getSale());
            pstmt.setLong(4,product.getStock());
            pstmt.setLong(5,product.getMarketDate());
            pstmt.setString(6,product.getImgUrl());
            pstmt.setString(7,product.getInfo());
            rows=pstmt.executeUpdate();
            System.out.println("商品插入成功"+rows+","+product);
        } catch (SQLException throwables) {
            System.out.println("DAO商品插入失败");
            throwables.printStackTrace();
        }
        return rows;
    }

    @Override
    public int update(Product product) {
        int rows=0;
        String sql="UPDATE product_table SET name=?,price=?,sale=?,stock=?,marketDate=?,imgUrl=?,info=? WHERE id=?";
        try {
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,product.getName());
            pstmt.setBigDecimal(2,product.getPrice());
            pstmt.setInt(3,product.getSale());
            pstmt.setLong(4,product.getStock());
            pstmt.setLong(5,product.getMarketDate());
            pstmt.setString(6,product.getImgUrl());
            pstmt.setString(7,product.getInfo());
            pstmt.setInt(8,product.getId());
            rows=pstmt.executeUpdate();
            System.out.println("DAO商品修改成功"+rows+","+product);
        } catch (SQLException throwables) {
            System.out.println("DAO商品修改失败");
            throwables.printStackTrace();
        }
        return rows;
    }

    @Override
    public int delete(int id) {
        int rows=0;
        String sql="DELETE FROM product_table where id=?";
        try {
            pstmt=conn.prepareStatement(sql);
            pstmt.setInt(1,id);
            rows=pstmt.executeUpdate();
            System.out.println("商品删除成功"+rows+",id="+id);
        } catch (SQLException throwables) {
            System.out.println("DAO商品删除失败");
            throwables.printStackTrace();
        }
        return rows;
    }

    @Override
    public int count() {
        int count=0;
        String sql="SELECT count(*) FROM product_table";
        try {
            stmt=conn.createStatement();
            rs=stmt.executeQuery(sql);
            while(rs.next()){
                count=rs.getInt(1);
            }
        } catch (SQLException throwables) {
            System.out.println("DAO商品数目获取失败");
            throwables.printStackTrace();
        }
        return count;
    }
}
