package com.angular7.customerapp.repositories;

import com.angular7.customerapp.models.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ItemRepository extends JpaRepository<Item,Long> {
    @Query("from Item i where i.isActive=1")
    public List<Item> getAllByIsActive();
}
