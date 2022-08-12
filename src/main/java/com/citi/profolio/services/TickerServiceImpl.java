package com.citi.profolio.services;

import com.citi.profolio.daos.TickerDao;
import com.citi.profolio.entities.Order;
import com.citi.profolio.entities.Ticker;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Optional;

@Service
public class TickerServiceImpl implements TickerService{

    @Autowired
    TickerDao tickerDao;

    private static final Logger logger = LogManager.getLogger(OrderServiceImpl.class);

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public Ticker selectTickerById(Integer id) {
        logger.info("Selecting ticker by id:{}", id);
        Optional<Ticker> ticker = tickerDao.findById(id);
        return ticker.orElse(null);
    }
}
