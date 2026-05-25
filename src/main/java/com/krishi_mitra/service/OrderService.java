package com.krishi_mitra.service;

import com.krishi_mitra.dto.request.OrderRequest;
import com.krishi_mitra.entity.Order;

import java.util.List;

public interface OrderService {
    Order placeOrder(OrderRequest request);
    List<Order> getAllOrders();
    List<Order> getOrdersByByuer(Long buyerId);
}
