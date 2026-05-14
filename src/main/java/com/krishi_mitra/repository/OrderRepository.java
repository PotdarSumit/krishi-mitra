package com.krishi_mitra.repository;

import com.krishi_mitra.entity.Order;
import com.krishi_mitra.enums.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long>{
    List<Order> findByBuyerId(Long buyerId);
    List<Order> findByStatus(OrderStatus status);
}
