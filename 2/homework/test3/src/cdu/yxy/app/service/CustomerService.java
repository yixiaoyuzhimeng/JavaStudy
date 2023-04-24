package cdu.yxy.app.service;

import cdu.yxy.app.model.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> findByPage(int page,int pageSize);
    List<Customer> findByPage(String sPage, String sPageSize);
    List<Customer> findByPage(String sPage);
    List<Customer> findVip(boolean isVip);
    Customer get(String sid);
    Customer get(String name,String password);
    int count();
    boolean add(Customer customer);
    boolean del(String sid);
    boolean mod(Customer customer);
}
