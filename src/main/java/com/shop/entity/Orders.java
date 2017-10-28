package com.shop.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Orders {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private LocalDateTime date;
	private String deliveryAddress;

	@ManyToMany
	@JoinTable(name = "orders_product",
	joinColumns = @JoinColumn(name = "orders_id"),
	inverseJoinColumns = @JoinColumn(name = "product_id"))
	private  List<Product> products = new ArrayList<Product>();

	@ManyToOne
	private User user;

	@ManyToMany
	@JoinTable(name = "orders_specefication",
			joinColumns = @JoinColumn(name = "orders_id"),
			inverseJoinColumns = @JoinColumn(name = "specefication_id"))
	private List<Specefication> specefications = new ArrayList<>();

	public Orders() {
	}

	public Orders(LocalDateTime date) {
		this.date = date;
	}

	public Orders(LocalDateTime date, String deliveryAddress) {
		super();
		this.date = date;
		this.deliveryAddress = deliveryAddress;

	}
	public String getDeliveryAddress() {
		return deliveryAddress;
	}
	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public List<Specefication> getSpecefications() {
		return specefications;
	}

	public void setSpecefications(List<Specefication> specefications) {
		this.specefications = specefications;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "Orders{" +
				"id=" + id +
				", date=" + date +
				", deliveryAddress='" + deliveryAddress + '\'' +
				", products=" + products +
				", specefications=" + specefications +
				'}';
	}
}