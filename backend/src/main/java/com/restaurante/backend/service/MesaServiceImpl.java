package com.restaurante.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurante.backend.entity.Mesa;
import com.restaurante.backend.repository.MesaRepository;


@Service
public class MesaServiceImpl implements MesaService{

	@Autowired
	MesaRepository mesaRepository;
	
	@Override
	public List<Mesa> getAllMesas() {
		return mesaRepository.findAll();
	}

	@Override
	public Mesa updateMesa(Mesa mesa) {
		return mesaRepository.save(mesa);
	}

}
