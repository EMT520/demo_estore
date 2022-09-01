package com.briup.estore.demo_estore.bean;

import java.util.List;

/**
 * @Author guomiao
 * @Date 2022/6/20 15:43
 */

public class OrderForm {
    private String cus_id;
    private String address;
    private double totalPrice;
    private String state;
    private List<OrderItem> items;
}
