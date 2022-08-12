package com.citi.profolio.services;

import com.citi.profolio.entities.Ticker;


public interface TickerService {
    Ticker selectTickerById(Integer id);
}
