package com.briup.estore.demo_estore.dao;

import com.briup.estore.demo_estore.bean.Customer;

/**
 * @Author guomiao
 * @Date 2022/6/20 11:55
 */

public interface ICustomerDao {
    Customer findByName(String username);
}
