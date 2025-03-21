package com.demo.product_service.service;

import com.demo.product_service.DTO.ProductRequest;
import com.demo.product_service.DTO.InventoryRequest;
import com.demo.product_service.DTO.ProductResponse;
import com.demo.product_service.client.inventoryClient;
import com.demo.product_service.model.Product;
import com.demo.product_service.repository.productRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class productService {
    private final productRepository repository;
    private final inventoryClient client;

    public ProductResponse createProduct(ProductRequest productRequest) {
        log.info("Creating product: {}", productRequest);

        Product product = Product.builder()
                .name(productRequest.name())
                .description(productRequest.description())
                .price(productRequest.price())
                .build();

        repository.save(product);

        var isInStock = client.isInStock(product.getId());

        if (!isInStock) {
            InventoryRequest inventoryRequest = InventoryRequest.builder()
                    .productId(product.getId())
                    .quantity(1)
                    .build();

            client.addToInventory(inventoryRequest);
            log.info("Product added to inventory: {}", product.getId());
        }

        log.info("Product created successfully");
        return new ProductResponse(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice()
        );
    }



    public List<ProductResponse> getAllProducts() {

        return repository.findAll()
                .stream()
                .map(product -> new ProductResponse(product.getId(), product.getName(), product.getDescription(), product.getPrice()))
                .toList();
    }
}
