package com.citi.profolio.services;

import com.citi.profolio.daos.OrderDao;
import com.citi.profolio.entities.ActionEnum;
import com.citi.profolio.entities.Order;
import com.citi.profolio.entities.StatusEnum;
import com.citi.profolio.entities.Ticker;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderDao orderDao;

    @Autowired
    TickerService tickerService;


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
        logger.info("Selecting all orders");
        return orderDao.findById(id).orElse(null);
    }


    @Override
    public Order createOrder(Order order){
        if (order == null || tickerService.selectTickerById(order.getId()) == null)
            return null;
        if (orderCanComplete(order)){
            order.setStatus(StatusEnum.COMPLETED.getStatus());
        } else{
            order.setStatus(StatusEnum.OPEN.getStatus());
        }
        logger.info("Adding order:{}", order.toString());

        return orderDao.save(order);
    }

    private boolean orderCanComplete(Order order){
        Ticker ticker = tickerService.selectTickerById(order.getId());
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
}
