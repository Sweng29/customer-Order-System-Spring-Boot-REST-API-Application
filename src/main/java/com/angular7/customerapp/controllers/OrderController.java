package com.angular7.customerapp.controllers;

import com.angular7.customerapp.models.Order;
import com.angular7.customerapp.models.ResponseEntity;
import com.angular7.customerapp.services.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@RestController
@RequestMapping(value = "api/orders")
public class OrderController {

    private OrderService orderService;
    private ResponseEntity<Order> responseApi;
    private List<Order> ordersList;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
        responseApi = new ResponseEntity<>();
        ordersList = new ArrayList<>();
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<Order> getAllOrders() {
        ordersList = orderService.getAll();
        if (ordersList.size() > 0) {
            responseApi.setStatus("200");
            responseApi.setMessage("success");
            responseApi.setResult(ordersList);
            return responseApi;
        }
        responseApi.setStatus("201");
        responseApi.setMessage("failed");
        responseApi.setResult(null);
        return responseApi;
    }

    @RequestMapping(value = "/order", method = RequestMethod.POST)
    public ResponseEntity<Order> addOrder(@RequestBody Order order) {
        if (order != null) {
            orderService.saveOrUpdate(order);
            responseApi.setStatus("200");
            responseApi.setResult(orderService.getAll());
            responseApi.setMessage("success");
            return responseApi;
        }
        responseApi.setStatus("201");
        responseApi.setMessage("failed");
        responseApi.setResult(null);
        return responseApi;
    }


    @RequestMapping(value = "/order", method = RequestMethod.PUT)
    public ResponseEntity<Order> updateOrder(@RequestBody Order order) {
        return addOrder(order);
    }

    @RequestMapping(value = "/order/{id}", method = RequestMethod.GET)
    public ResponseEntity<Order> getById(@RequestParam("id") Long id) {
        if (id != null && id > 0) {
            Order order = orderService.findById(id);
            responseApi.setStatus("200");
            responseApi.setResult(Arrays.asList(order));
            responseApi.setMessage("success");
            return responseApi;
        }
        responseApi.setStatus("201");
        responseApi.setMessage("failed");
        responseApi.setResult(null);
        return responseApi;
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Order> deleteById(@RequestParam Long id) {
        if (id != null && id > 0) {
            boolean check = orderService.deleteById(id);
            if (check) {
                responseApi.setStatus("200");
                responseApi.setResult(orderService.getAll());
                responseApi.setMessage("success");
                return responseApi;
            }
        }
        responseApi.setStatus("201");
        responseApi.setMessage("failed");
        responseApi.setResult(null);
        return responseApi;
    }
}
