package com.krishi_mitra.service;

import com.krishi_mitra.dto.request.ProductRequest;
import com.krishi_mitra.entity.Product;

import java.util.List;

public interface ProductService {
    Product addProduct(ProductRequest request);
    List<Product> getAllProducts();
    Product getProductById(Long id);
    void deleteProduct(Long id);
}
