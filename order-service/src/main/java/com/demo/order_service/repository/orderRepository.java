package com.demo.order_service.repository;

import com.demo.order_service.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface orderRepository extends JpaRepository<Order, Long> {
}
