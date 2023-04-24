package cdu.yxy.app.dao;
import cdu.yxy.app.model.CartItem;
import java.util.Map;
public interface CartDao {
     Map<Integer,Integer> find (int customerId);
     int insert(CartItem cartItem);
     int update(CartItem cartItem);
     int delete(CartItem cartItem);
     int delete(int customerId);
}
