package com.harshith.chaosdemo.order_service.orders.repo;

import com.harshith.chaosdemo.order_service.orders.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {}
