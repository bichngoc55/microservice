package com.demo.order_service.controller;

import com.demo.order_service.DTO.OrderDTO;
import com.demo.order_service.model.Order;
import com.demo.order_service.service.orderService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/order")
public class orderController {
    @Autowired
    private  orderService service;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public String createOrder(@RequestBody OrderDTO order) {
        System.out.println("hehehhe " + order);
         service.createOrder(order);
         return "created sucessfully";
    }
    

}
