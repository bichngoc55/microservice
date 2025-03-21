package com.demo.inventory_service.DTO;

public record InventoryRequest(String productId, Integer quantity) {
}
