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
    @Column(columnDefinition = "DATE")
    private Date fecha;
    @ManyToOne(optional = false, cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_mesa", nullable = false, updatable = false)
    private Mesa mesa;
    @ManyToOne(optional = false, cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    private User client;
	public Reserva(int id_reserva, @NotNull Date fecha, Mesa mesa, User client) {

		this.id_reserva = id_reserva;
		this.fecha = fecha;
		this.mesa = mesa;
		this.client = client;
	}
	public Reserva() {

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
