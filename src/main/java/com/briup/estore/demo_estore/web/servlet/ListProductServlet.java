package com.briup.estore.demo_estore.web.servlet;

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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author guomiao
 * @Date 2022/6/20 11:07
 */
//@WebServlet(name = "listProduct",value = "/listProduct.do")
public class ListProductServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        WebApplicationContext ac = WebApplicationContextUtils.getWebApplicationContext(this.getServletContext());
        ac.getBean("");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = resp.getWriter();
        writer.println();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection("", "", "");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from e_book");
            List<Map<String,Object>> list = new ArrayList<>();
            while(resultSet.next()){
                Map<String,Object> map = new HashMap<>();
                map.put("book_name",resultSet.getString("book_name"));
                list.add(map);
            }
           req.setAttribute("books",list);
        }catch (Exception e){

        }
    }
}
