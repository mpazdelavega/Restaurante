package com.restaurante.backend.service;

import java.util.List;

import com.restaurante.backend.entity.Hora_mesa;

public interface HoraMesaService {

	public List<Hora_mesa> getAllHoras();
	
	public Hora_mesa updateHora(Hora_mesa hora_mesa);
	
}
