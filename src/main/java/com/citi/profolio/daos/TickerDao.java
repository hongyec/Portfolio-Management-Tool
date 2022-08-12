package com.citi.profolio.daos;

import com.citi.profolio.entities.Ticker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TickerDao extends JpaRepository<Ticker, Integer> {

}
