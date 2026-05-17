package com.krishi_mitra.serviceImpl;

import com.krishi_mitra.dto.request.ProductRequest;
import com.krishi_mitra.entity.Product;
import com.krishi_mitra.exception.ResourceNotFoundException;
import com.krishi_mitra.repository.ProductRepository;
import com.krishi_mitra.service.ProductService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;


    @Override
    public Product addProduct(ProductRequest request) {
        Product product = Product.builder()
                .name(request.getName())
                .description(request.getDescription())
                .pricePerUnit(request.getPricePerUnit())
                .quantityAvailable(request.getQuantityAvailable())
                .unit(request.getUnit())
                .category(request.getCategory())
                .location(request.getLocation())
                .imageUrl(request.getImageUrl())
                .build();
        return productRepository.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Product not found..."));
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);

    }
}
