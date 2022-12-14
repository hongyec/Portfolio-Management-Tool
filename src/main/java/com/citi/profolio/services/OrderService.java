package com.citi.profolio.services;

import com.citi.profolio.entities.Order;


import java.util.Collection;

public interface OrderService {
    Order createOrder(Order order);

    Collection<Order> selectOrder();

    Order selectOrderById(Integer id);

    Collection<Order> selectOrderByStatus(String status);

    Collection<Order> updateOrderStatus();


}
