package com.restaurante.backend.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tipo_mesa")
public class Tipo_mesa {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_tipo_mesa;
	private String descripcion;
	private int capacidad;
	private String foto;
	

	public Tipo_mesa() {
		
	}
	public int getId_tipo_mesa() {
		return id_tipo_mesa;
	}
	public void setId_tipo_mesa(int is_tipo_mesa) {
		this.id_tipo_mesa = is_tipo_mesa;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getCapacidad() {
		return capacidad;
	}
	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	
	
	
	
}
