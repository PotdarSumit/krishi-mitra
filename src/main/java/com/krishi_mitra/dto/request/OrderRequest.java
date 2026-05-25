package com.krishi_mitra.dto.request;

import lombok.Data;

@Data
public class OrderRequest {
    private Long buyerId;
    private Long productId;
    private Integer quantity;
    private String deliveryAddress;
}
