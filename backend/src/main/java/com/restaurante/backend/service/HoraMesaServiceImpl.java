package com.restaurante.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurante.backend.entity.Hora_mesa;
import com.restaurante.backend.repository.HoraMesaRepository;

@Service
public class HoraMesaServiceImpl implements HoraMesaService{
	
	@Autowired
	HoraMesaRepository horaMesaRepository;

	@Override
	public List<Hora_mesa> getAllHoras() {
		return horaMesaRepository.findAll();
	}

	@Override
	public Hora_mesa updateHora(Hora_mesa hora_mesa) {
		return horaMesaRepository.save(hora_mesa);
	}

}
