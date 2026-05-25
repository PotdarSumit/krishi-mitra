package com.krishi_mitra.serviceImpl;

import com.krishi_mitra.dto.request.OrderRequest;
import com.krishi_mitra.entity.Order;
import com.krishi_mitra.entity.OrderItem;
import com.krishi_mitra.entity.Product;
import com.krishi_mitra.entity.User;
import com.krishi_mitra.exception.ResourceNotFoundException;
import com.krishi_mitra.repository.OrderRepository;
import com.krishi_mitra.repository.ProductRepository;
import com.krishi_mitra.repository.UserRepository;
import com.krishi_mitra.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;

    @Override
    public Order placeOrder(OrderRequest request) {
        User buyer = userRepository.findById(request
                .getBuyerId()).orElseThrow(() -> new ResourceNotFoundException("Buyer not found...."));
        Product product = productRepository.findById(request.getProductId())
                .orElseThrow(()-> new ResourceNotFoundException("Product not found.."));

        BigDecimal total = product.getPricePerUnit()
                .multiply(BigDecimal.valueOf(request.getQuantity()));

        Order order = Order.builder()
                .buyer(buyer)
                .deliveryAddress(request.getDeliveryAddress())
                .totalAmount(total)
                .build();

        OrderItem item = OrderItem.builder()
                .product(product)
                .quantity(request.getQuantity())
                .priceAtPurchase(product.getPricePerUnit())
                .order(order)
                .build();

        order.setItems(List.of(item));

        return orderRepository.save(order);
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public List<Order> getOrdersByByuer(Long buyerId) {
        return orderRepository.findByBuyerId(buyerId);
    }
}
