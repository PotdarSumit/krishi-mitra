package com.krishi_mitra.dto.request;

import com.krishi_mitra.enums.ProductCategory;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductRequest {
    private String name;
    private String description;
    private BigDecimal pricePerUnit;
    private Integer quantityAvailable;
    private String unit;
    private ProductCategory category;
    private String location;
    private String imageUrl;

}
