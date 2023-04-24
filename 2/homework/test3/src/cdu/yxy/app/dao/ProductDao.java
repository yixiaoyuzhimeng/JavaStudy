package cdu.yxy.app.dao;
import cdu.yxy.app.model.Product;
import java.util.List;
public interface ProductDao {
    Product get(int id);
    List<Product> findAll();
    List<Product> findByPage(int start,int num);
    int insert(Product product);
    int update(Product product);
    int delete(int id);
    int count();
}
