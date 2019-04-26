package com.angular7.customerapp.repositories;

import com.angular7.customerapp.models.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDetailsRepository extends JpaRepository<OrderDetails,Long> {
    @Query("from OrderDetails od where od.isActive=1")
    public List<OrderDetails> getAllByIsActive();
}
