package com.restaurante.backend.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="hora_mesa")
public class Hora_mesa {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_hora_mesa;
	private String hora;
	private String estado;
	
	@ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "id_mesa", nullable = false, updatable = false)
	private Mesa mesa;
	
	public Hora_mesa() {

	}
	
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Mesa getMesa() {
		return mesa;
	}

	public void setMesa(Mesa mesa) {
		this.mesa = mesa;
	}

	public int getId_hora_mesa() {
		return id_hora_mesa;
	}
	public void setId_hora_mesa(int id_hora_mesa) {
		this.id_hora_mesa = id_hora_mesa;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	
	
	


	
	
	

	
	
	
	
	
	

}
