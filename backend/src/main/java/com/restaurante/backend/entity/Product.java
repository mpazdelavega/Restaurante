package com.restaurante.backend.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Entity
@Table(name="plato")
public class Product {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank @NotNull
    private String name;
    @NotNull @DecimalMin(value = "0.1")
    private Double price;
    @NotBlank @NotNull
    private String description;
    @NotBlank @NotNull
    private String category;
    @NotBlank @NotNull
    private String image;
	public Product(int id, @NotBlank @NotNull String name, @NotNull @DecimalMin("0.1") Double price,
			@NotBlank @NotNull String description, @NotBlank @NotNull String category,
			@NotBlank @NotNull String image) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.description = description;
		this.category = category;
		this.image = image;
	}
	public Product() {

	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
    
    
}
