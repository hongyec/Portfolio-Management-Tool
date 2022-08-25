package com.citi.profolio.controllers;

import com.citi.profolio.entities.User;
import com.citi.profolio.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class HomeController {
    @Autowired
    UserService userService;

    @GetMapping
    public User getUserInfo(){
        return userService.getUserInfo();
    }
}
