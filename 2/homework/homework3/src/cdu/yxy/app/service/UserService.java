package cdu.yxy.app.service;
import cdu.yxy.app.model.User;
import java.util.List;
//用户相关的业务逻辑接口
public interface UserService {
    User login(User user);
    boolean register(User user);
    boolean add(User user);
    boolean mod(User user);
    boolean del(String sid);
    User get(String sid);
    User get(String name,String password);
    List<User> findByPage(int page,int pageSize);
    List<User> findByPage(String  sPage,String sPageSize);
    List<User> findByPage(String sPage);
    int count();
}