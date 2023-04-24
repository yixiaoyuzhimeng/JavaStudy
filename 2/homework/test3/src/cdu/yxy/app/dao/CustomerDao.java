package cdu.yxy.app.dao;
import cdu.yxy.app.model.Customer;
import java.util.List;
public interface CustomerDao {
    Customer get(int id);
    Customer get(String name,String password);
    List<Customer> findAll();
    List<Customer> findByPage(int start,int num);
    List<Customer> findVip(boolean isVip);
    int insert(Customer customer);
    int update(Customer customer);
    int delete(int id);
    int count();
}
