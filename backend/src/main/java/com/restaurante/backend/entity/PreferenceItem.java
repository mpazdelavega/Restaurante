package com.restaurante.backend.entity;

import java.io.Serializable;

public class PreferenceItem implements Serializable {
    private String title;
    private int quantity;
    private Double price;
    
    
	
    public PreferenceItem(String title, int quantity, Double price) {
		this.title = title;
		this.quantity = quantity;
		this.price = price;
	}

	public PreferenceItem() {
	}
    
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
    
    
}
