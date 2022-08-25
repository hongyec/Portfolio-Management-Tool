package com.citi.profolio.services;

import java.util.Collection;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.citi.profolio.daos.TickerDao;
import com.citi.profolio.entities.Ticker;

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

    @Transactional
    @Override
    public Collection<Ticker> selectTickers() {
        return tickerDao.findAll();
    }
}
