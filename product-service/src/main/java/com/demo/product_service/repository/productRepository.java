package com.demo.product_service.repository;

import com.demo.product_service.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface productRepository extends MongoRepository<Product,String> {
}
