package com.restaurante.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurante.backend.entity.Reserva;
import com.restaurante.backend.repository.ReservaRepository;

@Service
public class ReservaServiceImpl implements ReservaService{
	
	private final ReservaRepository reservaRepository;
	
	
	@Autowired
	public ReservaServiceImpl(ReservaRepository reservaRepository) {
		this.reservaRepository = reservaRepository;
	}
	
	public List<Reserva> getListByClient(String userName){
		return this.reservaRepository.findByClient_UserName(userName);
	}
	
	public void cleanReserva(int clientId) {
		this.reservaRepository.deleteByClient_Id(clientId);
	}
	
	public void removeReserva(int id) {
		this.reservaRepository.deleteById(id);
	}
	
	public void addReserva(Reserva reserva) {
		this.reservaRepository.save(reserva);
	}
	
	public Long getCountByClient(int clientId) {
		return this.reservaRepository.countByClient_Id(clientId);
	}

	@Override
	public Reserva updateReserva(Reserva reserva) {
		return reservaRepository.save(reserva);
	}
	
	
	
	
}
