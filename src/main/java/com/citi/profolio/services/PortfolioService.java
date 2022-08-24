package com.citi.profolio.services;

import com.citi.profolio.entities.Order;
import com.citi.profolio.entities.Portfolio;

import java.util.Collection;

public interface PortfolioService {
    Collection<Portfolio> selectAllShares();

    void updateShareNum(Order order);

    Portfolio selectPortfolioByTicker(Integer tickerId);

    void createPortfolio(Integer tickerId, Integer number);

}
