package com.restaurante.backend.entity;


//import java.util.List;

import javax.persistence.CascadeType;
//import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
//import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
//import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="mesa")
public class Mesa {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_mesa;
	private String estado;
	
	@ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "id_tipo_mesa", nullable = false, updatable = false)
	private Tipo_mesa tipo_mesa;
	
	public Mesa() {
		
	}
	
	public int getId_mesa() {
		return id_mesa;
	}
	public void setId_mesa(int id_mesa) {
		this.id_mesa = id_mesa;
	}

	public Tipo_mesa getTipo_mesa() {
		return tipo_mesa;
	}

	public void setTipo_mesa(Tipo_mesa tipo_mesa) {
		this.tipo_mesa = tipo_mesa;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}


	
	
	

	
	
	
	
	
	

}
