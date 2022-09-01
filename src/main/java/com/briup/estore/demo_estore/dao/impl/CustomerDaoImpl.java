package com.briup.estore.demo_estore.dao.impl;

import com.briup.estore.demo_estore.bean.Customer;
import com.briup.estore.demo_estore.dao.ICustomerDao;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * @Author guomiao
 * @Date 2022/6/20 11:55
 */

@Repository("cusDao")
public class CustomerDaoImpl implements ICustomerDao {
    @Override
    public Customer findByName(String username) {
        return null;
    }
}
