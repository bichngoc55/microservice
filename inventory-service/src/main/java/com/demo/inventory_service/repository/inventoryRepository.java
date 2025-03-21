package com.demo.inventory_service.repository;


import com.demo.inventory_service.model.Inventory;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface inventoryRepository extends MongoRepository<Inventory,String> {
    Optional<Inventory> findByProductId(String productId);
}
