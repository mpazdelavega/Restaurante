package com.restaurante.backend.service;

import java.util.List;

import com.restaurante.backend.entity.Mesa;

public interface MesaService {

	public List<Mesa> getAllMesas();
	
	public Mesa updateMesa(Mesa mesa);
}
