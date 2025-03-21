package com.demo.order_service.DTO;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record OrderDTO(Long id,
                       String customerName,
                       String customerPhone,
                       String customerAddress,
                       String customerEmail,
                       String orderStatus,
                       LocalDateTime orderDate,
                       Integer quantity,
                       BigDecimal price) {
}
 