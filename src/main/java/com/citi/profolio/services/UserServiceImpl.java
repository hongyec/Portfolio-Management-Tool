package com.citi.profolio.services;


import com.citi.profolio.entities.Portfolio;
import com.citi.profolio.entities.Ticker;
import com.citi.profolio.entities.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Collection;

@Service
public class UserServiceImpl implements UserService{
    final Logger LOGGER = LoggerFactory.getLogger(getClass());
    @Autowired
    ResourceLoader resourceLoader;

    @Autowired
    PortfolioService portfolioService;

    @Autowired
    TickerService tickerService;

    @Override
    public User getUserInfo() {
        String data = getFileData();
        if (data == null) return null;
        try
        {
            String[] s = data.split("\n");
            String username = s[0].split(":")[1].strip();
            Double balance = Double.valueOf(s[1].split(":")[1].strip());
            Double initial = Double.valueOf(s[2].split(":")[1].strip());
            Double overallGrowth = calculateOverallGrowth(balance, initial);
            return new User(username, balance, overallGrowth);
        } catch (NumberFormatException e) {
            LOGGER.error("Cannot Convert String into Float");
            return null;
        }
    }

    @Override
    public Double getUserBalance() {
        try {
            String data = getFileData();
            if (data == null) return null;
            String balance = data.split("\n")[1].split(":")[1].strip();
            return Double.valueOf(balance);
        } catch (NumberFormatException e){
            LOGGER.error("Cannot Convert String into Float");
            return null;
        }
    }
    private String getFileData(){
        Resource resource = resourceLoader.getResource("classpath:userinfo.txt");
        try {
            InputStream inputStream = resource.getInputStream();
            byte[] bdata = FileCopyUtils.copyToByteArray(inputStream);
            return new String(bdata, StandardCharsets.UTF_8);
        } catch (IOException e){
            LOGGER.error("IOException", e);
            return null;
        }
    }

    public double calculateOverallGrowth(Double balance, Double initial){
        double overall = 0;
        Collection<Portfolio> portfolios = portfolioService.selectAllShares();
        for (Portfolio p : portfolios){
            Ticker ticker = tickerService.selectTickerById(p.getTickerId());
            overall += ticker.getPrice() * p.getNumShare();
        }
        return overall + balance - initial;
    }

}
