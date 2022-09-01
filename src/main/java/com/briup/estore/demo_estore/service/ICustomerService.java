package com.briup.estore.demo_estore.service;

import com.briup.estore.demo_estore.bean.Customer;

/**
 * @Author guomiao
 * @Date 2022/6/20 12:01
 */

public interface ICustomerService {
    Customer login(String name, String password);
    void regist(Customer cus);
}
