package com.citi.profolio.services;

import com.citi.profolio.entities.Order;


import java.util.Collection;

public interface OrderService {
    Order createOrder(Order order);

    Collection<Order> selectOrder();


}
