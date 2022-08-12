package com.citi.profolio.services;

import com.citi.profolio.entities.Trade;

import java.util.Collection;

public interface TradeService {
    int createOrder(Trade trade);

    Collection<Trade> selectOrder();


}
