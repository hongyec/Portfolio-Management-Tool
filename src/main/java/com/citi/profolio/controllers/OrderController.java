package com.citi.profolio.controllers;

import com.citi.profolio.entities.Order;
import com.citi.profolio.entities.StatusEnum;
import com.citi.profolio.services.OrderService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Collection<Order>> selectOrder() {

        return new ResponseEntity<>(orderService.selectOrder(), HttpStatus.OK);
    }

    @PostMapping
    public Order createOrder(@RequestBody Order order) {
        logger.info("Creating order"+order.toString());
        Order resp = orderService.createOrder(order);
        return (resp == null) ? new ResponseEntity<>(resp, HttpStatus.NOT_ACCEPTABLE)
                : new ResponseEntity<>(resp, HttpStatus.OK);
    }

    @GetMapping(value="/{id}")
    public ResponseEntity<Order> selectOrderById(@PathVariable("id") Integer id) {
        Order resp =  orderService.selectOrderById(id);
        return (resp == null) ? new ResponseEntity<>(resp, HttpStatus.NOT_FOUND)
                : new ResponseEntity<>(resp, HttpStatus.OK);
    }

    @GetMapping(value = "/status={status}")
    public ResponseEntity<Collection<Order>> selectOrdersByStatus(@PathVariable("status") String status) {
        if (StatusEnum.valueOfStatus(status) == null){
            logger.warn("Invalid Status");
            return new ResponseEntity<>(null, HttpStatus.NOT_ACCEPTABLE);
        }
        return new ResponseEntity<>(orderService.selectOrderByStatus(status), HttpStatus.OK);
    }

    @GetMapping(value="/updateStatus")
    public ResponseEntity<Collection<Order>> updateOrderStatus(){
        return new ResponseEntity<>(orderService.updateOrderStatus(), HttpStatus.OK);
    }
}