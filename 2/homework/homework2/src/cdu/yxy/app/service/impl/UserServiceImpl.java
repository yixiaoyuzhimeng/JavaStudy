package cdu.yxy.app.service.impl;
import cdu.yxy.app.dao.UserDao;
import cdu.yxy.app.dao.impl.UserDaoImpl;
import cdu.yxy.app.model.User;
import cdu.yxy.app.service.UserService;
import java.util.List;
//用户相关的业务逻辑接口的实现类
public class UserServiceImpl implements UserService {
    UserDao userDao=new UserDaoImpl();
    @Override
    public User login(User user) {
        return null;
    }

    @Override
    public boolean register(User user) {
        return add(user);
    }

    @Override
    public boolean add(User user) {
        if(user==null){
            return false;
        }
       return userDao.insert(user)==1?true:false;
    }

    @Override
    public boolean mod(User user) {
        if(user==null){
            return false;
        }
        return userDao.update(user)==1?true:false;
    }

    @Override
    public boolean del(String sid) {
        int id=0;
        if( sid != null && !sid.equals(" ") ){
            id=Integer.parseInt(sid);
        }
        return userDao.delete(id)==1?true:false;
    }

    @Override
    public User get(String sid) {
        int id=0;
        if(sid!=null&& !sid.equals("")&& sid.length()>0){
            id=Integer.parseInt(sid);
        }
        return userDao.get(id);
    }

    @Override
    public List<User> findByPage(int page, int pageSize) {
        if(page<1){
            page=1;
        }
        return userDao.findByPage((page-1)*pageSize,pageSize);
    }

    @Override
    public List<User> findByPage(String sPage, String sPageSize) {
        int page=0;
        int pageSize=10;
        if(sPage!=null && !sPage.equals("")){
            page=Integer.parseInt(sPage);
        }
        if(sPageSize!=null && !sPageSize.equals("")){
            pageSize=Integer.parseInt(sPageSize);
        }
        return findByPage(page,pageSize);
    }

    @Override
    public List<User> findByPage(String sPage) {
        return findByPage(sPage,null);
    }

    @Override
    public int count() {
        return userDao.count();
    }
}
