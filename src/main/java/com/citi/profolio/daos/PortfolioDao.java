package com.citi.profolio.daos;

import com.citi.profolio.entities.Portfolio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PortfolioDao extends JpaRepository<Portfolio, Integer> {

    @Modifying
    @Query(value="UPDATE Portfolio t SET t.numShare = t.numShare + :number WHERE t.tickerId = :tickerId")
    public void increaseNumShare(@Param("tickerId") Integer tickerId, @Param("number") Integer number);

    @Modifying
    @Query(value="UPDATE Portfolio t SET t.numShare = t.numShare - :number WHERE t.tickerId = :tickerId")
    public void decreaseNumShare(@Param("tickerId") Integer tickerId, @Param("number") Integer number);

    @Query(value = "SELECT t FROM Portfolio t WHERE t.tickerId = :tickerId")
    public Portfolio selectPortfolioByTickerId(@Param("tickerId") Integer tickerId);

    @Modifying
    @Query(value = "INSERT INTO Portfolio (tickerId, numShare) VALUES (:tickerId, :number)", nativeQuery = true)
    public void createPortfolioByTicker(@Param("tickerId") Integer tickerId, @Param("number") Integer number);
}
