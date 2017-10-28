package com.shop.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Sex {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String type;

	@OneToMany(mappedBy = "sex")
	private List<User> user = new ArrayList<>();
	
	@OneToMany(mappedBy = "sex")
	private List<Staff> staff;
	
	public Sex(){
		
	}
	
	public Sex(String type) {
		super();
		this.type = type;
	}

	public List<User> getUser() {
		return user;
	}

	public void setUser(List<User> user) {
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Sex [id=" + id + ", type=" + type + "]";
	}
	
}
