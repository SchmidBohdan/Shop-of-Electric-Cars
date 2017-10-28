package com.shop.entity;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
public class Specefication {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String pathImage;

	private String description;


	@Type(type="text")
	private String recipe;

	@ManyToOne
	private Product product;
	
	@ManyToOne
	private Property property;
	
	@ManyToOne
	private SpeceficationType speceficationType;

	@ManyToMany
	@JoinTable(name = "orders_specefication",
			joinColumns = @JoinColumn(name = "specefication_id"),
			inverseJoinColumns = @JoinColumn(name = "orders_id"))
	private List<Orders> orders = new ArrayList<>();

	@ManyToMany
	@JoinTable(name = "specefication_user",
			joinColumns = @JoinColumn(name = "id_specefication"),
			inverseJoinColumns = @JoinColumn(name = "id_user"))
	private List<User> drinks = new ArrayList<>();

	public Specefication(){
		
	}
	
	public Specefication(String description) {
		super();
		this.description = description;
	}

	public Specefication(int id, String description, String recipe) {
		this.id=id;
		this.description = description;
		this.recipe = recipe;
	}
	public String getRecipe() {
		return recipe;
	}

	public void setRecipe(String recipe) {
		this.recipe = recipe;
	}

	public List<User> getDrinks() {
		return drinks;
	}

	public void setDrinks(List<User> drinks) {
		this.drinks = drinks;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Property getProperty() {
		return property;
	}

	public void setProperty(Property property) {
		this.property = property;
	}

	public SpeceficationType getSpeceficationType() {
		return speceficationType;
	}

	public void setSpeceficationType(SpeceficationType speceficationType) {
		this.speceficationType = speceficationType;
	}

	public List<Orders> getOrders() {
		return orders;
	}

	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public String getPathImage() {
		return pathImage;
	}

	public void setPathImage(String pathImage) {
		this.pathImage = pathImage;
	}

	@Override
	public String toString() {
		return "Specefication{" +
				"id=" + id +
				", description='" + description + '\'' +
				", product=" + product +
				", property=" + property +
				", speceficationType=" + speceficationType +
				", orders=" + orders +
				'}';
	}
}
