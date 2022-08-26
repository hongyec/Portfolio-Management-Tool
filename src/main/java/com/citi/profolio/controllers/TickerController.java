package com.citi.profolio.controllers;


import com.citi.profolio.entities.Ticker;
import com.citi.profolio.services.TickerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@CrossOrigin
@RequestMapping("/tickers")
public class TickerController {
    @Autowired
    TickerService tickerService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Ticker> selectTickerById(@PathVariable Integer id) {
        Ticker resp = tickerService.selectTickerById(id);
        return (resp == null) ? new ResponseEntity<>(resp, HttpStatus.NOT_FOUND)
                : new ResponseEntity<>(resp, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Collection<Ticker>> selectTickers() {
        return new ResponseEntity<>(tickerService.selectTickers(), HttpStatus.OK);
    }
}