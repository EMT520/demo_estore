package com.briup.estore.demo_estore.web.servlet;

import com.briup.estore.demo_estore.bean.Customer;
import com.briup.estore.demo_estore.service.ICustomerService;
import com.briup.estore.demo_estore.service.impl.CustomerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author guomiao
 * @Date 2022/6/20 10:16
 */

public class RegistServlet extends HttpServlet {
    private ICustomerService cusService = new CustomerServiceImpl();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1. 获取请求参数。
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String age = req.getParameter("age");


        Customer cus = new Customer();
        cus.setName(name);
        cus.setPassword(password);
        cus.setAge((age==null||"".equals(age.trim()))?0:Integer.parseInt(age));
        cus.setEmail(email);

        cusService.regist(cus);

        //2. 处理参数
        //3. 处理业务
            //3.1 注册的用户名必须唯一。
            // 连接数据，查找看数据库中是否有当前用户弥怒个存在
        //4. 数据库访问， 连接数据库进行处理
        // 根据不同的业务结果，给出不同的响应。
        // req.getRequestDispatcher("/xxxx").forward(req,resp);
        //resp.sendRedirect("xxxx");
    }
}
