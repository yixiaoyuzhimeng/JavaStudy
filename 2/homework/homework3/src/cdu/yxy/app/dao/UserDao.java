package cdu.yxy.app.dao;
import cdu.yxy.app.model.User;
import java.util.List;
//用户实体数据库访问接口
public interface UserDao {
    User get(int id);
    List<User> findAll();
    List<User> findByPage(int start,int num);
    int insert(User user);
    int update(User user);
    int delete(int id);
    int count();
}
