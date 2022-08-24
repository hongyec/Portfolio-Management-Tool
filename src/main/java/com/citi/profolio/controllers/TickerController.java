package com.citi.profolio.controllers;


import com.citi.profolio.entities.Ticker;
import com.citi.profolio.services.TickerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/tickers")
public class TickerController {
    @Autowired
    TickerService tickerService;

    @GetMapping(value = "/{id}")
    public Ticker selectTickerById(@PathVariable Integer id) {
        return tickerService.selectTickerById(id);
    }

    @GetMapping
    public Collection<Ticker> selectTickers() {
        return tickerService.selectTickers();
    }
}