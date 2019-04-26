package com.angular7.customerapp.services;

import com.angular7.customerapp.generics.Generic;
import com.angular7.customerapp.models.Order;
import com.angular7.customerapp.repositories.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService implements Generic<Order> {

    private OrderRepository orderRepository;
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public List<Order> getAll() {
        return this.orderRepository.getAllByIsAndIsActive();
    }

    @Override
    public Order saveOrUpdate(Order entity) {
        return this.orderRepository.save(entity);
    }

    @Override
    public boolean deleteById(Long id) {
        this.orderRepository.deleteById(id);
        return true;
    }

    @Override
    public Order findById(Long id) {
        return this.orderRepository.findById(id).get();
    }
}
