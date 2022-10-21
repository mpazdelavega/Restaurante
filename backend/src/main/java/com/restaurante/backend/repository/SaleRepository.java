package com.restaurante.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restaurante.backend.entity.Sale;

import java.util.List;

public interface SaleRepository extends JpaRepository<Sale,Integer> {
    List<Sale> findByClient_UserName(String userName);
}
