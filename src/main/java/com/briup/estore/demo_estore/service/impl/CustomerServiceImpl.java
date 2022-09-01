package com.briup.estore.demo_estore.service.impl;

import com.briup.estore.demo_estore.bean.Customer;
import com.briup.estore.demo_estore.dao.ICustomerDao;
import com.briup.estore.demo_estore.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author guomiao
 * @Date 2022/6/20 12:01
 */
@Service("cusService")
public class CustomerServiceImpl implements ICustomerService {
    @Autowired
    private ICustomerDao cusDao ;
    public CustomerServiceImpl(){
        System.out.println("CustomerServiceImpl对象被创建。。。");
    }

    public void setCusDao(ICustomerDao cusDao) {
        System.out.println("spring自动调用，进行cusDao的注入。");
        this.cusDao = cusDao;
    }

    public ICustomerDao getCusDao() {
        return cusDao;
    }

    @Override
    public Customer login(String name, String password) {
            if(name==null || "".equals(name.trim())){
                throw new RuntimeException("用户名不能为空！");
            }
            if(password==null || "".equals(password.trim())){
             throw new RuntimeException("密码不能为空！");
            }
            Customer user = cusDao.findByName(name);
            if(user==null){
                throw new RuntimeException("用户名密码错误！");
            }
            if(!user.getPassword().equals(password)){
                throw new RuntimeException("用户名密码错误！");
            }
            return user;
    }

    @Override
    public void regist(Customer cus) {

    }
}
