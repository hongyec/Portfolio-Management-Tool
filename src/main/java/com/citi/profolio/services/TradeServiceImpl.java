package com.citi.profolio.services;

import com.citi.profolio.daos.TradeDao;
import com.citi.profolio.entities.Trade;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class TradeServiceImpl implements TradeService{

    @Autowired
    TradeDao tradeDao;

    private static final Logger logger = LogManager.getLogger(TradeServiceImpl.class);

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public Collection<Trade> selectOrder(){
        return new ArrayList<>();
    }

    @Override
    public int createOrder(Trade trade){
        return 0;
    }
}
