package cdu.yxy.app.service;
import cdu.yxy.app.model.Product;
import java.util.List;
import java.util.Map;
public interface ProductService {
    List<Product> findByPage(int page,int pageSize);
    List<Product> findByPage(String sPage,String sPageSize);
    List<Product> findByPage(String sPage);
    Product get(String sid);
    Product get(int id);
    int count();
    boolean add(Product product);
    boolean del(String sid);
    boolean mod(Product product);
    boolean updateStock(Map<Integer,Integer> products);
}
