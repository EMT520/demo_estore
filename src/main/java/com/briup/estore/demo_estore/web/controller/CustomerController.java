package com.briup.estore.demo_estore.web.controller;

import com.briup.estore.demo_estore.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author guomiao
 * @Date 2022/6/21 15:47
 */
@Controller //SpringMVC中用来进行业务处理的逻辑控制器
public class CustomerController {

    @Autowired
    private ICustomerService customerService;

    @RequestMapping(value = "/login.do",method = {RequestMethod.GET,RequestMethod.POST})
    public String login(@RequestParam(required = false,name = "name") String username, String password){
        System.out.println("登录处理。。。。。。");
        System.out.println("name : "+username+" ... password: "+password);
        System.out.println("customerService.... "+customerService);
        //customerService.login("","");
        return "index";
    }
}
