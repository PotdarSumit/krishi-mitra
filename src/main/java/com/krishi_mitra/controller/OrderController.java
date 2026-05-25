package com.krishi_mitra.controller;

import com.krishi_mitra.dto.request.OrderRequest;
import com.krishi_mitra.entity.Order;
import com.krishi_mitra.service.OrderService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @PostMapping
    public Order placeOrder(@RequestBody OrderRequest request){
        return orderService.placeOrder(request);
    }

    @GetMapping
    public List<Order> getAllOrders(){
        return orderService.getAllOrders();
    }

    @GetMapping("/buyer/{buyerId}")
    public List<Order> getOrdersByBuyer(@PathVariable Long buyerId){
        return orderService.getOrdersByByuer(buyerId);
    }
}
