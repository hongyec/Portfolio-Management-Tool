package com.citi.profolio.controllers;

import com.citi.profolio.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/completedorders")
public class CompleteOrderController {
    @Autowired
    OrderService orderService;



}
