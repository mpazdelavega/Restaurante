package com.restaurante.backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restaurante.backend.entity.Reserva;

public interface ReservaRepository extends JpaRepository<Reserva, Integer>{
	List<Reserva> findByClient_Id(String clientId);
	List<Reserva> findByClient_UserName(String clientEmail);
	void deleteByClient_Id(String clientId);
	Long countByClient_Id(String id);
}
