package com.briup;

import com.briup.estore.demo_estore.dao.ICustomerDao;
import com.briup.estore.demo_estore.service.ICustomerService;
import com.briup.estore.demo_estore.service.impl.CustomerServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author guomiao
 * @Date 2022/6/21 9:27
 */

public class SpringTest {

    @Test
    public void ioc(){
        //ApplicationContext ac = new ClassPathXmlApplicationContext("spring-ioc.xml");
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring-ioc-anno.xml");
        System.out.println("--------------容器初始化成功----------------");
        CustomerServiceImpl cusService = ac.getBean("cusService", CustomerServiceImpl.class);
        System.out.println("cusService:"+cusService);
        System.out.println("cusDao:"+cusService.getCusDao());
        System.out.println("0--------------直接从容器中获取cusDao-----------------");
        System.out.println("cusDao 容器中："+ac.getBean("cusDao", ICustomerDao.class));
    }
}
