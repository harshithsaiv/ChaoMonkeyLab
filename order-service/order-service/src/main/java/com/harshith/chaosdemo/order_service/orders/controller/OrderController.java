package com.harshith.chaosdemo.order_service.orders.controller;

import com.harshith.chaosdemo.order_service.orders.model.Order;
import com.harshith.chaosdemo.order_service.orders.repo.OrderRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderRepository repo;

    public OrderController(OrderRepository repo) { this.repo = repo; }

    @GetMapping
    public List<Order> all() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getById(@PathVariable Long id) {
        return repo.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Order create(@RequestBody Order order) {
        return repo.save(order);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Order> update(@PathVariable Long id,
                                        @RequestBody Order updated) {
        return repo.findById(id).map(order -> {
            order.setUserId(updated.getUserId());
            order.setProduct(updated.getProduct());
            order.setQuantity(updated.getQuantity());
            order.setPrice(updated.getPrice());
            order.setOrderDate(LocalDateTime.now());
            repo.save(order);
            return ResponseEntity.ok(order);
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!repo.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        repo.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

