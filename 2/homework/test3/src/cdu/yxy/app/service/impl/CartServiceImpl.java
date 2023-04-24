package cdu.yxy.app.service.impl;
import cdu.yxy.app.dao.CartDao;
import cdu.yxy.app.dao.CustomerDao;
import cdu.yxy.app.dao.ProductDao;
import cdu.yxy.app.dao.impl.CartDaoImpl;
import cdu.yxy.app.dao.impl.CustomerDaoImpl;
import cdu.yxy.app.dao.impl.ProductDaoImpl;
import cdu.yxy.app.model.CartItem;
import cdu.yxy.app.service.CartService;
import java.util.Map;
public class CartServiceImpl implements CartService {
    CustomerDao customerDao=new CustomerDaoImpl();
    ProductDao productDao=new ProductDaoImpl();
    CartDao cartDao=new CartDaoImpl();
    @Override
    public Map<Integer, Integer> getProducts(int customerId) {
        return cartDao.find(customerId);
    }
    @Override
    public boolean in(int customerId, String sProductId) {
        if(sProductId==null||sProductId.equals("")){
            return false;
        }
        CartItem cartItem=new CartItem();
        cartItem.setCustomerId(customerId);
        cartItem.setProductId(Integer.parseInt(sProductId));
        cartItem.setProductNum(1);
        return cartDao.insert(cartItem)==1?true:false;
    }
    @Override
    public boolean update(int customerId, String sProductId, int num) {
        if(sProductId==null||sProductId.equals("")){
            return false;
        }
        CartItem cartItem=new CartItem();
        cartItem.setCustomerId(customerId);
        cartItem.setProductId(Integer.parseInt(sProductId));
        cartItem.setProductNum(num);
        return cartDao.update(cartItem)==1?true:false;
    }
    @Override
    public boolean out(int customerId, String sProductId) {
        if(sProductId==null||sProductId.equals("")){
            return false;
        }
        CartItem cartItem=new CartItem();
        cartItem.setCustomerId(customerId);
        cartItem.setProductId(Integer.parseInt(sProductId));
        return cartDao.delete(cartItem)==1?true:false;
    }
    @Override
    public boolean clear(int customerId) {
        return cartDao.delete(customerId)>0?true:false;
    }
}
