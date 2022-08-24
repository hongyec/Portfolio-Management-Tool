package com.citi.profolio.services;

import com.citi.profolio.daos.OrderDao;
import com.citi.profolio.entities.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;
import java.util.Collection;
import java.util.Date;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderDao orderDao;

    @Autowired
    TickerService tickerService;

    @Autowired
    PortfolioService portfolioService;

    private static final Logger logger = LogManager.getLogger(OrderServiceImpl.class);

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public Collection<Order> selectOrder(){
        logger.info("Selecting all orders");
        return orderDao.findAll();
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public Order selectOrderById(Integer id){
        logger.info("Selecting order by id:{}", id);
        return orderDao.findById(id).orElse(null);
    }


    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public Order createOrder(Order order){
        //Check if the order and the ticker exist,
        //and if the user has shares to sell.
        if (order == null || tickerService.selectTickerById(order.getTickerId()) == null || !ableToSell(order))
            return null;

        Date today = new Date(System.currentTimeMillis());
        //Set order created date.
        if (order.getCreatedDate() == null) order.setCreatedDate(today);
        //Set order good till.
        setGoodTill(order, today);
        //Check whether the order can be completed.
        if (orderCanComplete(order)){
            order.setCompletedDate(new Date(System.currentTimeMillis()));
            order.setStatus(StatusEnum.COMPLETED.getStatus());
            //Update Number of Shares in Portfolio
            portfolioService.updateShareNum(order);
        } else{
            order.setStatus(StatusEnum.OPEN.getStatus());
        }
        logger.info("Adding order:{}", order.toString());
        return orderDao.save(order);
    }

    private void setGoodTill(Order order, Date date){
        if (order.getCreatedDate() == null) order.setCreatedDate(date);
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.MONTH, 3);
        order.setGoodTill(cal.getTime());
    }
    private boolean orderCanComplete(Order order){
        Ticker ticker = tickerService.selectTickerById(order.getTickerId());
        String action = order.getAction();
        if (action.equals(ActionEnum.BUY.getAction())){
            return order.getMarketPrice() >= ticker.getPrice();
        } else{
            return order.getMarketPrice() <= ticker.getPrice();
        }
    }
    @Override
    public Collection<Order> selectOrderByStatus(String status){
        if (StatusEnum.valueOfStatus(status) == null){
            logger.warn("Invalid Status");
            return null;
        }
        return orderDao.getOrdersByStatus(status);
    }

    private boolean ableToSell(Order order){
        Portfolio portfolio = portfolioService.selectPortfolioByTicker(order.getTickerId());
        if (order.getAction().equals(ActionEnum.SELL.getAction())
                && (portfolio == null || portfolio.getNumShare() - order.getNumShares() < 0)) {
            logger.warn("Unable to sell");
            return false;
        }
        return true;
    }
}
