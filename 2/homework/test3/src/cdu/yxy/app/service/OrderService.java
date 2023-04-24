package cdu.yxy.app.service;
import cdu.yxy.app.model.Order;
import java.util.List;
public interface OrderService {
    Order get(String orderId);
    List<Order> findByPage(int page, int pageSize);
    List<Order> findByPage(String sPage);
    List<Order> findByCustomer(String sCustomerId);
    int count();
    boolean createOrder(Order order);
    boolean updateStatus(Order order);
    boolean del(String orderId);
}
