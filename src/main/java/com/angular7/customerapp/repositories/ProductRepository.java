package com.angular7.customerapp.repositories;

import com.angular7.customerapp.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("from Product i where i.isActive=1")
    List<Product> getAllByIsActive();
}
