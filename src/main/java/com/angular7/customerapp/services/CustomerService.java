package com.angular7.customerapp.services;

import com.angular7.customerapp.generics.Generic;
import com.angular7.customerapp.models.Customer;
import com.angular7.customerapp.repositories.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CustomerService implements Generic<Customer> {

    private CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository)
    {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> getAll() {
        return customerRepository.getAllByIsActive();
    }

    @Override
    public Customer saveOrUpdate(Customer entity) {
        return this.customerRepository.save(entity);
    }

    @Override
    public boolean deleteById(Long id) {
        Customer customer = findById(id);
        if(customer!=null)
        {
            customerRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public Customer findById(Long id) {
        return this.customerRepository.findById(id).get();
    }
}
