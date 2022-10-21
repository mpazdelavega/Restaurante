package com.restaurante.backend.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restaurante.backend.entity.Message;
import com.restaurante.backend.entity.Reserva;
import com.restaurante.backend.service.ReservaServiceImpl;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/reserva")
public class ReservaController {
	private final ReservaServiceImpl reservaService;

	@Autowired
	public ReservaController(ReservaServiceImpl reservaService) {
		this.reservaService = reservaService;
	}
	
	@GetMapping()
	public ResponseEntity<List<Reserva>> getListByClient(){
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();
		String userName = userDetails.getUsername();
		return new ResponseEntity<>(this.reservaService.getListByClient(userName), HttpStatus.OK);
	}
	
	@GetMapping("/count/{client_id}")
	public ResponseEntity<Long> contByClient(@PathVariable("client_id")int id){
		return new ResponseEntity<>(this.reservaService.getCountByClient(id), HttpStatus.OK);
	}
	
	
	
	@PostMapping()
	public ResponseEntity<Message> addReserva(@Valid @RequestBody Reserva reserva, 
												BindingResult bindingResult){
		if (bindingResult.hasErrors())
			return new ResponseEntity<>(new Message("Error al crear reserva"),HttpStatus.BAD_REQUEST);
		this.reservaService.addReserva(reserva);
		return new ResponseEntity<>(new Message("Reserva creada"),HttpStatus.OK);
	}
	
	@DeleteMapping("/clean/{item_id}")
	public ResponseEntity<Message> removeReserva(@PathVariable("item_id")int id){
		this.reservaService.removeReserva(id);
		return new ResponseEntity<>(new Message("Reserva eliminada"),HttpStatus.OK);
	}
	
	@PutMapping("/update")
	private String add(@RequestBody Reserva reserva)
	{
		reservaService.updateReserva(reserva);
		return "Reserva actualizada";
	}
	
	
	
}
