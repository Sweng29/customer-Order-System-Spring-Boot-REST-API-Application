package com.angular7.customerapp.services;

import com.angular7.customerapp.generics.Generic;
import com.angular7.customerapp.models.Item;
import com.angular7.customerapp.repositories.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ItemService implements Generic<Item> {

    private ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @Override
    public List<Item> getAll() {
        return itemRepository.getAllByIsActive();
    }

    @Override
    public Item saveOrUpdate(Item entity) {
        return itemRepository.save(entity);
    }

    @Override
    public boolean deleteById(Long id) {
        itemRepository.deleteById(id);
        return true;
    }

    @Override
    public Item findById(Long id) {
        return itemRepository.findById(id).get();
    }
}
