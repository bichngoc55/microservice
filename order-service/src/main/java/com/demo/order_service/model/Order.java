package com.demo.order_service.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name="orders")
@Data
@Getter
@Setter
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @Column(name = "customer_name")
    private String customerName;

//    @Column(name = "customer_phone")
    private String customerPhone;

//    @Column(name = "customer_address")
    private String customerAddress;

//    @Column(name = "customer_email")
    private String customerEmail;

//    @Column(name = "order_status")
    private String orderStatus;

//    @Column(name = "order_date")
    private LocalDateTime orderDate;

//    @Column(name = "quantity")
    private Integer quantity;

//    @Column(name = "price")
    private BigDecimal price;
//    public Order(Long id, String customerName, String customerPhone, String customerAddress,
//                 String customerEmail, String orderStatus, LocalDateTime orderDate,
//                 Integer quantity, BigDecimal price) {
//        this.id = id;
//        this.customerName = customerName;
//        this.customerPhone = customerPhone;
//        this.customerAddress = customerAddress;
//        this.customerEmail = customerEmail;
//        this.orderStatus = orderStatus;
//        this.orderDate = orderDate;
//        this.quantity = quantity;
//        this.price = price;
//    }


    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }



    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }



    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }


    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }



    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }


    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }


    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }


    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
