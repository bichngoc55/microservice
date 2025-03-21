package com.demo.product_service.controller;

import com.demo.product_service.DTO.ProductRequest;
import com.demo.product_service.DTO.ProductResponse;
import com.demo.product_service.model.Product;
import com.demo.product_service.service.productService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class productController {
    private final productService service;
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ProductResponse createProduct(@RequestBody ProductRequest productRequest) {
        return service.createProduct(productRequest);
    }

    @GetMapping

    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> getAllProducts() {
        return service.getAllProducts();
    }
}
