package com.restaurante.backend.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;


@Entity
public class Reserva {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_reserva;
	@NotNull
    @Column(columnDefinition = "DATE", updatable = false, nullable = false)
    private Date fecha;

	@NotNull
    private String estado_reserva;
    @ManyToOne(optional = false, cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_mesa", nullable = false, updatable = false)
    private Mesa mesa;
    @ManyToOne(optional = false, cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, updatable = false)
    private User client;
    
    @ManyToOne(optional = false, cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@JoinColumn(name = "id_hora_mesa", nullable = false, updatable = false)
	private Hora_mesa hora_mesa;
	
    public Reserva() {

	}

	public String getEstado_reserva() {
		return estado_reserva;
	}

	public void setEstado_reserva(String estado_reserva) {
		this.estado_reserva = estado_reserva;
	}

	public Hora_mesa getHora_mesa() {
		return hora_mesa;
	}

	public void setHora_mesa(Hora_mesa hora_mesa) {
		this.hora_mesa = hora_mesa;
	}

	public int getId_reserva() {
		return id_reserva;
	}
	public void setId_reserva(int id_reserva) {
		this.id_reserva = id_reserva;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Mesa getMesa() {
		return mesa;
	}
	public void setMesa(Mesa mesa) {
		this.mesa = mesa;
	}
	public User getClient() {
		return client;
	}
	public void setClient(User client) {
		this.client = client;
	}
   
}
