package com.krishi_mitra.repository;

import com.krishi_mitra.entity.Product;
import com.krishi_mitra.enums.ProductCategory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByFarmerId(Long farmerId);
    List<Product> findByCategory(ProductCategory category);
    List<Product> findByIsAvailableTrue(Pageable pageable);
    Page<Product> findByNameContainingIgnoreCaseAndIsAvailableTrue(
            String keyword,
            Pageable pageable
    );

    List<Product> findByLocationContainingIgnoreCase(String location);

}
