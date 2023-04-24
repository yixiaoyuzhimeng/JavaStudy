package cdu.yxy.app.dao;
import cdu.yxy.app.model.Order;
import java.util.List;
public interface OrderDao {
    Order get(String orderId);
    List<Order> findAll();
    List<Order> findByPage(int start,int num);
    List<Order> findByCustomer(int customerId);
    int insert(Order order);
    int update(Order order);
    int delete(String orderId);//这里是字符型的，和其他有区分，why?TODO
    int count();
}
