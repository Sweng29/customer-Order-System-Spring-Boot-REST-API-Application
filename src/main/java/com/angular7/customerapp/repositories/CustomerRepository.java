package com.angular7.customerapp.repositories;

import com.angular7.customerapp.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@Repository
@CrossOrigin(origins = "*")
public interface CustomerRepository extends JpaRepository<Customer,Long> {

    @Query("from Customer  c where c.isActive = 1")
    public List<Customer> getAllByIsActive();
}
