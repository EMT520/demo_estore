package com.briup.estore.demo_estore.utils;

import com.briup.estore.demo_estore.service.ICustomerService;
import com.briup.estore.demo_estore.service.impl.CustomerServiceImpl;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @Author guomiao
 * @Date 2022/6/21 8:27
 */

public class BeanFactory {
    static Properties prop = new Properties();
    static{
        //读取配置文件。获取字符串和类名之间的对应关系，并维护。
        try {
            prop.load(BeanFactory.class.getResourceAsStream("/bean.properties"));
            System.out.println(prop);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static Object getBean(String name){
        //将字符串和需要构建的类的名字的匹配信息，以配置文件的形式存在。
        String clasName = prop.getProperty(name);
        System.out.println("clasName "+clasName);
        if(clasName==null||"".equals(clasName.trim())){
            return null;
        }
        try {
            Object bean = Class.forName(clasName).newInstance();
            return bean;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public static void main(String[] args) {
        Object cusDao = getBean("cusDao");
        System.out.println("cusDao : "+cusDao);
    }
}
