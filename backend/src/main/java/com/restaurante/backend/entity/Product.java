package com.restaurante.backend.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Product {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;
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
	public Product(String id, @NotBlank @NotNull String name, @NotNull @DecimalMin("0.1") Double price,
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
	public String getId() {
		return id;
	}
	public void setId(String id) {
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
