package com.citi.profolio.controllers;

import com.citi.profolio.entities.Portfolio;
import com.citi.profolio.services.PortfolioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/portfolio")
public class PortfolioController {
    @Autowired
    PortfolioService portfolioService;

    @GetMapping
    public Collection<Portfolio> getAllShares(){
        return portfolioService.selectAllShares();
    }


    @GetMapping(value = "/{tickerId}")
    public  Portfolio selectShareByTickerId(@PathVariable Integer tickerId){
        return portfolioService.selectPortfolioByTicker(tickerId);
    }

}
