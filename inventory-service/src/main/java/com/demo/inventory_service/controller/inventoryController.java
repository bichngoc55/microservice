package com.demo.inventory_service.controller;


import com.demo.inventory_service.DTO.InventoryRequest;
import com.demo.inventory_service.DTO.InventoryResponse;
import com.demo.inventory_service.model.Inventory;
import com.demo.inventory_service.service.inventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/inventory")
@RestController
@Controller
@RequiredArgsConstructor
public class inventoryController {
    private final inventoryService service;
    @PostMapping
    public ResponseEntity<Void> addInventory( @RequestBody InventoryRequest request) {
        service.addInventory(request);
        return ResponseEntity.ok().build();
    }
    @GetMapping
    public List<InventoryResponse> getInventory() {
        return service.getAllInventory();
    }
    @GetMapping("/{id}")
    public InventoryResponse getInventoryById(@PathVariable String id) {
        return service.getInventoryById(id);
    }
    @GetMapping("/check/{productId}")
    public boolean isInStock(@PathVariable String productId) {
        return service.isInStock(productId);
    }

}
