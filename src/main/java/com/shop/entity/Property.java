package com.shop.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Property {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;

	@OneToMany(mappedBy = "property")
	private List<Specefication> specefications = new ArrayList<>();

	public Property() {

	}

	public Property(String name) {
		super();
		this.name = name;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Property{" +
				"id=" + id +
				", name='" + name + '\'' +
				", specefications=" + specefications +
				'}';
	}
}