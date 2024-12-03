package com.demo.order_service.service;

import com.demo.order_service.DTO.OrderDTO;
import com.demo.order_service.model.Order;
import com.demo.order_service.repository.orderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class orderService {
    @Autowired
    private  orderRepository repository;

    public void  createOrder (OrderDTO orderDTO){
        Order order = new Order();
        System.out.println(orderDTO);
        order.setCustomerName(orderDTO.customerName());
        order.setCustomerPhone(orderDTO.customerPhone());
        order.setCustomerAddress(orderDTO.customerAddress());
        order.setCustomerEmail(orderDTO.customerEmail());
        order.setOrderStatus(orderDTO.orderStatus());
        order.setOrderDate(orderDTO.orderDate());
        order.setQuantity(orderDTO.quantity());
        order.setPrice(orderDTO.price());

        repository.save(order);
    }
}
