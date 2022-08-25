package com.citi.profolio.controllers;

import com.citi.profolio.entities.Order;
import com.citi.profolio.entities.StatusEnum;
import com.citi.profolio.services.OrderService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/orders")
@CrossOrigin
public class OrderController {
    @Autowired
    OrderService orderService;

    private static final Logger logger = LogManager.getLogger(OrderController.class);

    @GetMapping
    public Collection<Order> selectOrder() {
        return orderService.selectOrder();
    }

    @PostMapping
    public Order createOrder(@RequestBody Order order) {
        return orderService.createOrder(order);
    }

    @GetMapping(value="/{id}")
    public Order selectOrderById(@PathVariable("id") Integer id) {
        return orderService.selectOrderById(id);
    }

    @GetMapping(value = "?status={status}")
    public Collection<Order> selectOrdersByStatus(@PathVariable("status") String status) {
        return orderService.selectOrderByStatus(status);
    }

    @GetMapping(value="/updateStatus")
    public Collection<Order> updateOrderStatus(){return orderService.updateOrderStatus();}
}