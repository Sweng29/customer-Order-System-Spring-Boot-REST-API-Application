package com.angular7.customerapp.controllers;

import com.angular7.customerapp.models.Product;
import com.angular7.customerapp.models.ResponseEntity;
import com.angular7.customerapp.services.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "api/products")
public class ProductController {

    private ProductService productService;
    private ResponseEntity<Product> responseEntity;
    private List<Product> productList;

    public ProductController(ProductService productService) {
        this.productService = productService;
        this.productList = new ArrayList<>();
        this.responseEntity = new ResponseEntity<>();
    }

    @RequestMapping(path = {"/"}, method = RequestMethod.GET)
    public ResponseEntity<Product> getAllProducts() {
        productList = productService.getAll();
        System.out.println(productList.size());
        if (productList.size() > 0) {
            responseEntity.setStatus("200");
            responseEntity.setMessage("Success");
            responseEntity.setResult(productList);
            return responseEntity;
        } else {

            responseEntity.setStatus("404");
            responseEntity.setMessage("failed");
            responseEntity.setResult(null);
            return responseEntity;
        }
    }

    @RequestMapping(path = "/product", method = RequestMethod.POST)
    public ResponseEntity addProduct(@RequestBody Product product) {
        if (product != null) {
            product = productService.saveOrUpdate(product);
            responseEntity.setStatus("200");
            responseEntity.setMessage("success");
            responseEntity.setResult(productService.getAll());
        }
        responseEntity.setStatus("201");
        responseEntity.setMessage("failed");
        responseEntity.setResult(null);
        return responseEntity;
    }

    @RequestMapping(value = "/product", method = RequestMethod.PUT)
    public ResponseEntity<Product> updateProduct(@RequestBody Product product) {
        if (product != null && product.getProductId() != null) {
            responseEntity.setStatus("200");
            responseEntity.setMessage("success");
            responseEntity.setResult(productService.getAll());
        }
        responseEntity.setStatus("201");
        responseEntity.setMessage("failed");
        responseEntity.setResult(null);
        return responseEntity;
    }

    @RequestMapping(value = "/product/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Product> deleteProduct(@RequestParam Long id) {
        if (id != null && productService.deleteById(id)) {
            responseEntity.setStatus("200");
            responseEntity.setMessage("success");
            responseEntity.setResult(productService.getAll());
        }
        responseEntity.setStatus("201");
        responseEntity.setMessage("failed");
        responseEntity.setResult(null);
        return responseEntity;
    }

    @RequestMapping(value = "/product/{id}", method = RequestMethod.GET)
    public ResponseEntity<Product> getProductById(@RequestParam Long id) {
        if (id != null) {
            responseEntity.setStatus("200");
            responseEntity.setMessage("success");
            responseEntity.setResult(Arrays.asList(productService.findById(id)));
        }
        responseEntity.setStatus("201");
        responseEntity.setMessage("failed");
        responseEntity.setResult(null);
        return responseEntity;
    }
}
