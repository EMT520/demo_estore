package com.briup.estore.demo_estore.web.servlet;

import com.briup.estore.demo_estore.bean.Customer;
import com.briup.estore.demo_estore.dao.ICustomerDao;
import com.briup.estore.demo_estore.dao.impl.CustomerDaoImpl;
import com.briup.estore.demo_estore.service.ICustomerService;
import com.briup.estore.demo_estore.service.impl.CustomerServiceImpl;
import com.briup.estore.demo_estore.utils.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author guomiao
 * @Date 2022/6/20 10:16
 */

//@WebServlet(name = "login",value = "/login.do")
public class LoginServlet extends HttpServlet {
    public LoginServlet(){
        System.out.println("LoginServlet对象创建。。。。。");
    }
    //从Spring的容器中获取Spring创建并维护好的cusService对象。
    private ICustomerService cusService ;

    @Override
    public void init() throws ServletException {
        WebApplicationContext ac = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
        cusService = ac.getBean(ICustomerService.class);
        System.out.println("cusService...."+cusService);
    }

    /**
     *
     * @param req 客户端发送过来的所有请求相关的内容都在HttpServletRequest中。
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/plain;charset=UTF-8");
        req.getHeader("Content-Type");
        //获取请求参数
        String name = req.getParameter("name");
        String password = req.getParameter("password");

        try{
            // 调用业务处理代码
            Customer login = cusService.login(name, password);
            //根据业务结果不同，跳转不同页面。
            req.getRequestDispatcher("listProduct.do").forward(req,resp);
        }catch (Exception e){
            e.printStackTrace();
            req.setAttribute("msg",e.getMessage());
            req.getRequestDispatcher("login.jsp").forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
