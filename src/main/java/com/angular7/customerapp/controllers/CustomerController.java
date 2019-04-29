package com.angular7.customerapp.controllers;

import com.angular7.customerapp.models.Customer;
import com.angular7.customerapp.models.ResponseEntity;
import com.angular7.customerapp.services.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "api/customers")
public class CustomerController {

    private CustomerService customerService;
    private ResponseEntity responseEntity;
    private List<Customer> customers = new ArrayList<>();

    public CustomerController(CustomerService customerService)
    {
        this.customerService = customerService;
        responseEntity = new ResponseEntity();
    }

    @RequestMapping(path = {"/"}, method = RequestMethod.GET)
    public ResponseEntity<Customer> getAllCustomers()
    {
        customers = customerService.getAll();
        System.out.println(customers.size());
        if(customers.size()>0)
        {
            responseEntity.setStatus("200");
            responseEntity.setMessage("Success");
            responseEntity.setResult(customers);
            return responseEntity;
        }else {

            responseEntity.setStatus("404");
            responseEntity.setMessage("failed");
            responseEntity.setResult(null);
            return responseEntity;
        }
    }

    @RequestMapping(path = "/customer", method = RequestMethod.POST)
    public ResponseEntity addCustomer(@RequestBody Customer customer)
    {
        if (customer != null) {
            customer = customerService.saveOrUpdate(customer);
            responseEntity.setStatus("200");
            responseEntity.setMessage("success");
            responseEntity.setResult(customerService.getAll());
        }
        responseEntity.setStatus("201");
        responseEntity.setMessage("failed");
        responseEntity.setResult(null);
        return responseEntity;
    }

    @RequestMapping(value = "/customer", method = RequestMethod.PUT)
    public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer) {
        if (customer != null && customer.getCustomerId() != null) {
            responseEntity.setStatus("200");
            responseEntity.setMessage("success");
            responseEntity.setResult(customerService.getAll());
        }
        responseEntity.setStatus("201");
        responseEntity.setMessage("failed");
        responseEntity.setResult(null);
        return responseEntity;
    }

    @RequestMapping(value = "/customer/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Customer> deleteCustomer(@RequestParam Long id) {
        if (id != null && customerService.deleteById(id)) {
            responseEntity.setStatus("200");
            responseEntity.setMessage("success");
            responseEntity.setResult(customerService.getAll());
        }
        responseEntity.setStatus("201");
        responseEntity.setMessage("failed");
        responseEntity.setResult(null);
        return responseEntity;
    }

    @RequestMapping(value = "/customer/{id}", method = RequestMethod.GET)
    public ResponseEntity<Customer> getCustomerById(@RequestParam Long id) {
        if (id != null) {
            responseEntity.setStatus("200");
            responseEntity.setMessage("success");
            responseEntity.setResult(Arrays.asList(customerService.findById(id)));
        }
        responseEntity.setStatus("201");
        responseEntity.setMessage("failed");
        responseEntity.setResult(null);
        return responseEntity;
    }
}
