package com.restaurante.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restaurante.backend.entity.Mesa;
import com.restaurante.backend.service.MesaService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/mesa")
public class MesaController {
	
	@Autowired
	MesaService mesaService;
	
	@GetMapping("/getAll")
	public List<Mesa> getAllMesas(){
		return mesaService.getAllMesas();
	}
	
	@PutMapping("/update")
	private String add(@RequestBody Mesa mesa)
	{
		mesaService.updateMesa(mesa);
		return "Mesa actualizada";
	}

}
