package com.harshith.chaosdemo.order_service.orders.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;           // who bought it
    private String product;        // what they bought
    private Integer quantity;      // how many units
    private BigDecimal price;      // unit price (or total)
    private LocalDateTime orderDate; // when it happened


    // Constructors
    public Order() {}
    public Order(Long userId, String product, Integer quantity, BigDecimal price) {
        this.userId = Long.valueOf(userId);
        this.product = product;
        this.quantity = quantity;
        this.price = price;
    }

    // Getters & Setters
    public Long getId() { return id; }
    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }
    public String getProduct() { return product; }
    public void setProduct(String product) { this.product = product; }
    public Integer getQuantity() { return quantity; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }
    public BigDecimal getPrice() { return price; }
    public void setPrice(BigDecimal price) { this.price = price; }
    public LocalDateTime getOrderDate() { return orderDate; }
    public void setOrderDate(LocalDateTime orderDate) { this.orderDate = orderDate;}

}


