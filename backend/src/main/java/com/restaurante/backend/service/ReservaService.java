package com.restaurante.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.restaurante.backend.entity.Reserva;
import com.restaurante.backend.repository.ReservaRepository;

@Service
@Transactional
public class ReservaService {
	
	private final ReservaRepository reservaRepository;
	
	@Autowired
	public ReservaService(ReservaRepository reservaRepository) {
		this.reservaRepository = reservaRepository;
	}
	
	public List<Reserva> getListByClient(String userName){
		return this.reservaRepository.findByClient_UserName(userName);
	}
	
	public void cleanReserva(String clientId) {
		this.reservaRepository.deleteByClient_Id(clientId);
	}
	
	public void removeReserva(int id) {
		this.reservaRepository.deleteById(id);
	}
	
	public void addReserva(Reserva reserva) {
		this.reservaRepository.save(reserva);
	}
	
	public Long getCountByClient(String clientId) {
		return this.reservaRepository.countByClient_Id(clientId);
	}
	
	
}
