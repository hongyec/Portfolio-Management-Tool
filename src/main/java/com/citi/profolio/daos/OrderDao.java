package com.citi.profolio.daos;

import com.citi.profolio.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;


@Repository
public interface OrderDao extends JpaRepository<Order, Integer> {
    @Query(value = "SELECT o FROM Order o WHERE o.status = :status")
    public Collection<Order> getOrdersByStatus(@Param("status") String status);

    @Modifying
    @Query(value = "UPDATE Order o SET o.status = :status WHERE o.id = :id")
    public void updateOrdersStatus(@Param("status") String status, @Param("id") int id);
}
