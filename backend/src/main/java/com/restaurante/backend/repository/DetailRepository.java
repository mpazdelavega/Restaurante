package com.restaurante.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restaurante.backend.entity.Detail;

import java.util.List;

public interface DetailRepository extends JpaRepository<Detail, String> {
    List<Detail> findBySale_Id(String saleId);
}
