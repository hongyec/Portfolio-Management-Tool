package com.citi.profolio.services;


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

@Service
public class UserServiceImpl implements UserService{
    final Logger LOGGER = LoggerFactory.getLogger(getClass());
    @Autowired
    ResourceLoader resourceLoader;


    @Override
    public User getUserInfo() {
        String data = getFileData();
        if (data == null) return null;
        try
        {
            String[] s = data.split("\n");
            String username = s[0].split(":")[1].strip();
            String balance = s[1].split(":")[1].strip();
            return new User(username, Double.valueOf(balance), 0d);
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
}
