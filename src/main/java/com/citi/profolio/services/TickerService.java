package com.citi.profolio.services;

import com.citi.profolio.entities.Ticker;

import java.util.Collection;


public interface TickerService {
    Ticker selectTickerById(Integer id);
    Collection<Ticker> selectTickers();

}
