package com.demo.inventory_service.service;


import com.demo.inventory_service.DTO.InventoryRequest;
import com.demo.inventory_service.DTO.InventoryResponse;
import com.demo.inventory_service.model.Inventory;
import com.demo.inventory_service.repository.inventoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class inventoryService {
    private final inventoryRepository repository;
    public InventoryResponse addInventory(InventoryRequest request ) {
        Inventory inventory = Inventory.builder()
                .productId(request.productId())
                .quantity(request.quantity())
                .build();
        repository.save(inventory);
        log.info("Inventory created successfully");
        return new InventoryResponse(inventory.getId(), inventory.getProductId(), inventory.getQuantity() );
    }

    public List<InventoryResponse> getAllInventory() {
        return repository.findAll()
                .stream()
                .map(inventory -> new InventoryResponse(inventory.getId(), inventory.getProductId(), inventory.getQuantity()))
                .toList();
    }
    public InventoryResponse getInventoryById(String id) {
       return repository.findById(id)
               .map(inventory -> new InventoryResponse(inventory.getId(), inventory.getProductId(), inventory.getQuantity()))
               .orElseThrow(()->new RuntimeException("Inventory not found"));
    }
    public boolean isInStock(String productId) {
        return repository.findByProductId(productId)
                .map(inventory -> inventory.getQuantity() > 0)
                .orElse(false);
        }

}
