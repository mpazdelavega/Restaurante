package com.restaurante.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.restaurante.backend.entity.Mesa;


@Repository
public interface MesaRepository extends JpaRepository<Mesa, Integer>{

}
