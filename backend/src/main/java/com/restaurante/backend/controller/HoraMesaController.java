package com.restaurante.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restaurante.backend.entity.Hora_mesa;
import com.restaurante.backend.service.HoraMesaService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/horaMesa")
public class HoraMesaController {

	@Autowired
	HoraMesaService horaMesaService ;
	
	@GetMapping("/getAll")
	public List<Hora_mesa> getAllMesas(){
		return horaMesaService.getAllHoras();
	}
	
	@PutMapping("/update")
	private String add(@RequestBody Hora_mesa hora_mesa)
	{
		horaMesaService.updateHora(hora_mesa);
		return "Hora actualizada";
	}
	
}
