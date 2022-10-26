package com.restaurante.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.restaurante.backend.entity.Product;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Integer> {
    
	List<Product> findByCategoryAndIdNot(String category, int ProductId);
    List<Product> findFirst4ByOrderByPriceAsc();
    
    @Query(value="select * from plato where category != 'extras'", nativeQuery = true)
    List<Product> findAllWithoutEx();
}
