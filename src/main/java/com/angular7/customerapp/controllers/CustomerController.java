package com.angular7.customerapp.controllers;

import com.angular7.customerapp.models.Customer;
import com.angular7.customerapp.models.ResponseEntity;
import com.angular7.customerapp.services.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CustomerController {

    private CustomerService customerService;
    private ResponseEntity responseEntity;
    private List<Customer> customers = new ArrayList<>();

    public CustomerController(CustomerService customerService)
    {
        this.customerService = customerService;
    }

    @RequestMapping(path = {"/"})
    public ResponseEntity getAllCustomers()
    {
        customers = customerService.getAll();
        responseEntity = new ResponseEntity();
        System.out.println(customers.size());
        if(customers.size()>0)
        {
            responseEntity.setStatus("200");
            responseEntity.setMessage("Success");
            responseEntity.setResult(customers);
            return responseEntity;
        }else {

            responseEntity.setStatus("404");
            responseEntity.setMessage("Resource not found");
            responseEntity.setResult(null);
            return responseEntity;
        }
    }

    @RequestMapping(path = "/",method = RequestMethod.POST)
    public ResponseEntity addCustomer(@RequestBody Customer customer)
    {
        System.out.println("Adding customer");
        responseEntity = new ResponseEntity();
        customerService.saveOrUpdate(customer);
        responseEntity.setStatus("200");
        responseEntity.setMessage("Success fully added");
        responseEntity.setResult(Arrays.asList(customer));
        return responseEntity;
    }
}
