package com.angular7.customerapp.controllers;

import com.angular7.customerapp.models.Item;
import com.angular7.customerapp.models.ResponseEntity;
import com.angular7.customerapp.services.ItemService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "api/items")
public class ItemController {

    private ItemService itemService;
    private ResponseEntity<Item> responseEntity;
    private List<Item> itemList;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
        this.itemList = new ArrayList<>();
        this.responseEntity = new ResponseEntity<>();
    }

    @RequestMapping(path = {"/"}, method = RequestMethod.GET)
    public ResponseEntity<Item> getAllItems() {
        itemList = itemService.getAll();
        System.out.println(itemList.size());
        if (itemList.size() > 0) {
            responseEntity.setStatus("200");
            responseEntity.setMessage("Success");
            responseEntity.setResult(itemList);
            return responseEntity;
        } else {

            responseEntity.setStatus("404");
            responseEntity.setMessage("failed");
            responseEntity.setResult(null);
            return responseEntity;
        }
    }

    @RequestMapping(path = "/item", method = RequestMethod.POST)
    public ResponseEntity addItem(@RequestBody Item item) {
        if (item != null) {
            item = itemService.saveOrUpdate(item);
            responseEntity.setStatus("200");
            responseEntity.setMessage("success");
            responseEntity.setResult(itemService.getAll());
        }
        responseEntity.setStatus("201");
        responseEntity.setMessage("failed");
        responseEntity.setResult(null);
        return responseEntity;
    }

    @RequestMapping(value = "/item", method = RequestMethod.PUT)
    public ResponseEntity<Item> updateItem(@RequestBody Item item) {
        if (item != null && item.getItemId() != null) {
            responseEntity.setStatus("200");
            responseEntity.setMessage("success");
            responseEntity.setResult(itemService.getAll());
        }
        responseEntity.setStatus("201");
        responseEntity.setMessage("failed");
        responseEntity.setResult(null);
        return responseEntity;
    }

    @RequestMapping(value = "/item/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Item> deleteItem(@RequestParam Long id) {
        if (id != null && itemService.deleteById(id)) {
            responseEntity.setStatus("200");
            responseEntity.setMessage("success");
            responseEntity.setResult(itemService.getAll());
        }
        responseEntity.setStatus("201");
        responseEntity.setMessage("failed");
        responseEntity.setResult(null);
        return responseEntity;
    }

    @RequestMapping(value = "/item/{id}", method = RequestMethod.GET)
    public ResponseEntity<Item> getItemById(@RequestParam Long id) {
        if (id != null) {
            responseEntity.setStatus("200");
            responseEntity.setMessage("success");
            responseEntity.setResult(Arrays.asList(itemService.findById(id)));
        }
        responseEntity.setStatus("201");
        responseEntity.setMessage("failed");
        responseEntity.setResult(null);
        return responseEntity;
    }
}
