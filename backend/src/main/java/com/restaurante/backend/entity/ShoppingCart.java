package com.restaurante.backend.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name="Pedido")
public class ShoppingCart {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;
    @ManyToOne(optional = false, cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, updatable = false)
    private Product product;
    @ManyToOne(optional = false, cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, updatable = false)
    private User client;
    @NotNull
    private int amount;
    
    private String estado_pedido;
    
	public ShoppingCart() {
		
	}
	
	
	
	public ShoppingCart(String id, Product product, User client, @NotNull int amount, String estado_pedido) {
		this.id = id;
		this.product = product;
		this.client = client;
		this.amount = amount;
		this.estado_pedido = estado_pedido;
	}
	public String getEstado_pedido() {
		return estado_pedido;
	}
	public void setEstado_pedido(String estado_pedido) {
		this.estado_pedido = estado_pedido;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public User getClient() {
		return client;
	}
	public void setClient(User client) {
		this.client = client;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	
    
    
}
