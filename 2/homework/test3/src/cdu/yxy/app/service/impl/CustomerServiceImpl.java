package cdu.yxy.app.service.impl;
import cdu.yxy.app.dao.CustomerDao;
import cdu.yxy.app.dao.impl.CustomerDaoImpl;
import cdu.yxy.app.model.Customer;
import cdu.yxy.app.service.CustomerService;
import java.util.List;
public class CustomerServiceImpl implements CustomerService {
    CustomerDao customerDao=new CustomerDaoImpl();
    @Override
    public List<Customer> findByPage(int page, int pageSize) {
        return customerDao.findByPage((page-1)*pageSize,pageSize);
    }

    @Override
    public List<Customer> findByPage(String sPage, String sPageSize) {
        int page=1;
        int pageSize=10;
        if(sPage!=null||!sPage.equals("")){
            page=Integer.parseInt(sPage);
            if(page<1){
                page=1;
            }
        }
        if(sPageSize!=null ||!sPageSize.equals("")){
            pageSize=Integer.parseInt(sPageSize);
        }
        return findByPage(page,pageSize);
    }

    @Override
    public List<Customer> findByPage(String sPage) {
        return findByPage(sPage,null);
    }

    @Override
    public List<Customer> findVip(boolean isVip) {
        return customerDao.findVip(isVip);
    }

    @Override
    public Customer get(String sid) {
        if(sid==null||sid.equals("")){
            return null;
        }
        return customerDao.get(Integer.parseInt(sid));
    }

    @Override
    public Customer get(String name, String password) {
        return customerDao.get(name,password);
    }

    @Override
    public int count() {
        return customerDao.count();
    }

    @Override
    public boolean add(Customer customer) {
        if(customer==null){
            return false;
        }
        return customerDao.insert(customer)==1?true:false;
    }

    @Override
    public boolean del(String sid) {
        if(sid==null||sid.equals("")){
            return false;
        }
        return customerDao.delete(Integer.parseInt(sid))==1?true:false;
    }

    @Override
    public boolean mod(Customer customer) {
        if(customer==null){
            return false;
        }
        return customerDao.update(customer)==1?true:false;
    }
}
