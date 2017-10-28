package com.shop.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Manufacturer {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private  String name;
	private String description;

	private String pathImage;

	
	@OneToMany(mappedBy = "manufacturer")
	private List<Product> products = new ArrayList<>();
	
	@ManyToOne
	public Country country;
	
	public Manufacturer(){
		
	}
	
	public Manufacturer(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}

	public String getPathImage() {
		return pathImage;
	}

	public void setPathImage(String pathImage) {
		this.pathImage = pathImage;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Manufacturer{" +
				"id=" + id +
				", name='" + name + '\'' +
				", description='" + description + '\'' +
				", products=" + products +
				", country=" + country +
				'}';
	}
}
