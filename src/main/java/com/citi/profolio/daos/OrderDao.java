package com.citi.profolio.daos;

import com.citi.profolio.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDao extends JpaRepository<Order, Integer> {

}
