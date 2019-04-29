package com.angular7.customerapp.controllers;

import com.angular7.customerapp.models.OrderDetails;
import com.angular7.customerapp.models.ResponseEntity;
import com.angular7.customerapp.services.OrderDetailsService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "api/order-details")
public class OrderDetailController {

    private OrderDetailsService orderDetailsService;
    private ResponseEntity<OrderDetails> responseApi;
    private List<OrderDetails> orderDetailsList;

    public OrderDetailController(OrderDetailsService orderDetailsService) {
        this.orderDetailsService = orderDetailsService;
        responseApi = new ResponseEntity<>();
        orderDetailsList = new ArrayList<>();
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<OrderDetails> getAllOrderDetails() {
        orderDetailsList = orderDetailsService.getAll();
        if (orderDetailsList.size() > 0) {
            responseApi.setStatus("200");
            responseApi.setMessage("success");
            responseApi.setResult(orderDetailsList);
            return responseApi;
        }
        responseApi.setStatus("201");
        responseApi.setMessage("failed");
        responseApi.setResult(null);
        return responseApi;
    }

    @RequestMapping(value = "/order-detail", method = RequestMethod.POST)
    public ResponseEntity<OrderDetails> addOrderDetails(@RequestBody OrderDetails orderDetails) {
        if (orderDetails != null) {
            orderDetailsService.saveOrUpdate(orderDetails);
            responseApi.setStatus("200");
            responseApi.setResult(orderDetailsService.getAll());
            responseApi.setMessage("success");
            return responseApi;
        }
        responseApi.setStatus("201");
        responseApi.setMessage("failed");
        responseApi.setResult(null);
        return responseApi;
    }


    @RequestMapping(value = "/order-detail", method = RequestMethod.PUT)
    public ResponseEntity<OrderDetails> updateOrder(@RequestBody OrderDetails orderDetails) {
        return addOrderDetails(orderDetails);
    }

    @RequestMapping(value = "/order-detail/{id}", method = RequestMethod.GET)
    public ResponseEntity<OrderDetails> getById(@RequestParam("id") Long id) {
        if (id != null && id > 0) {
            OrderDetails orderDetails = orderDetailsService.findById(id);
            responseApi.setStatus("200");
            responseApi.setResult(Arrays.asList(orderDetails));
            responseApi.setMessage("success");
            return responseApi;
        }
        responseApi.setStatus("201");
        responseApi.setMessage("failed");
        responseApi.setResult(null);
        return responseApi;
    }

    @RequestMapping(value = "/order-detail/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<OrderDetails> deleteById(@RequestParam Long id) {
        if (id != null && id > 0) {
            boolean check = orderDetailsService.deleteById(id);
            if (check) {
                responseApi.setStatus("200");
                responseApi.setResult(orderDetailsService.getAll());
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
