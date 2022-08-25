package com.citi.profolio.controllers;

import com.citi.profolio.entities.Portfolio;
import com.citi.profolio.services.PortfolioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Collection<Portfolio>> getAllShares(){
        return new ResponseEntity<>(portfolioService.selectAllShares(), HttpStatus.OK);
    }


    @GetMapping(value = "/{tickerId}")
    public  ResponseEntity<Portfolio> selectShareByTickerId(@PathVariable Integer tickerId){
        Portfolio resp = portfolioService.selectPortfolioByTicker(tickerId);
        return (resp == null) ? new ResponseEntity<>(resp, HttpStatus.NOT_FOUND)
                : new ResponseEntity<>(resp, HttpStatus.OK);
    }

}
