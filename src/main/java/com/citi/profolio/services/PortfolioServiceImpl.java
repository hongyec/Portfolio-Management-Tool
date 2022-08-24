package com.citi.profolio.services;

import com.citi.profolio.daos.PortfolioDao;
import com.citi.profolio.entities.ActionEnum;
import com.citi.profolio.entities.Order;
import com.citi.profolio.entities.Portfolio;
import com.citi.profolio.entities.StatusEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
public class PortfolioServiceImpl implements PortfolioService {

    @Autowired
    PortfolioDao portfolioDao;

    @Transactional
    @Override
    public Collection<Portfolio> selectAllShares(){
        return portfolioDao.findAll();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void updateShareNum(Order order){
        Integer tickerId = order.getTickerId();
        if (!order.getStatus().equals(StatusEnum.COMPLETED.getStatus())) return;

        if (order.getAction().equals(ActionEnum.BUY.getAction())){
            if (selectPortfolioByTicker(tickerId) == null) {
                createPortfolio(tickerId, order.getNumShares());
            } else {
                portfolioDao.increaseNumShare(tickerId, order.getNumShares());
            }
        } else {
            portfolioDao.decreaseNumShare(tickerId, order.getNumShares());
        }
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public Portfolio selectPortfolioByTicker(Integer tickerId){
        return portfolioDao.selectPortfolioByTickerId(tickerId);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void createPortfolio(Integer tickerId, Integer number){
        portfolioDao.createPortfolioByTicker(tickerId, number);
    }
}
