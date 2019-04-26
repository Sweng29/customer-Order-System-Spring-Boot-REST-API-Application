package com.angular7.customerapp.repositories;

import com.angular7.customerapp.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {
    @Query("from Order o where o.isActive =1")
    List<Order> getAllByIsAndIsActive();
}
