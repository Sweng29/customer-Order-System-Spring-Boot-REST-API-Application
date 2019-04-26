package com.angular7.customerapp.services;

import com.angular7.customerapp.generics.Generic;
import com.angular7.customerapp.models.OrderDetails;
import com.angular7.customerapp.repositories.OrderDetailsRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderDetailsService implements Generic<OrderDetails> {

    private OrderDetailsRepository orderDetailsRepository;

    public OrderDetailsService(OrderDetailsRepository orderDetailsRepository) {
        this.orderDetailsRepository = orderDetailsRepository;
    }

    @Override
    public List<OrderDetails> getAll() {
        return this.orderDetailsRepository.getAllByIsActive();
    }

    @Override
    public OrderDetails saveOrUpdate(OrderDetails entity) {
        return this.orderDetailsRepository.save(entity);
    }

    @Override
    public boolean deleteById(Long id) {
        this.orderDetailsRepository.deleteById(id);
        return true;
    }

    @Override
    public OrderDetails findById(Long id) {
        return this.orderDetailsRepository.findById(id).get();
    }
}
