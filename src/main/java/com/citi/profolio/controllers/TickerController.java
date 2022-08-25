package com.citi.profolio.controllers;


import com.citi.profolio.entities.Ticker;
import com.citi.profolio.services.TickerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@CrossOrigin
@RequestMapping("/tickers")
public class TickerController {
    @Autowired
    TickerService tickerService;

    @GetMapping(value = "/{id}")
    public Ticker selectTickerByid(@PathVariable Integer id) {
        return tickerService.selectTickerById(id);
    }

    @GetMapping
    public Collection<Ticker> selectTickers() {
        return tickerService.selectTickers();
    }
}