package com.restaurante.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restaurante.backend.entity.Product;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,String> {
    List<Product> findByCategoryAndIdNot(String category, String ProductId);
    List<Product> findFirst4ByOrderByPriceAsc();
}
