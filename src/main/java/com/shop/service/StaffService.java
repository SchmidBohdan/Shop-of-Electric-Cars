package com.shop.service;

import java.util.List;

import com.shop.entity.Staff;



public interface StaffService {
	
void save(Staff staff);
	
	List<Staff> findAll();
	
	Staff findOne(int id);
	
	void delete(int id); 
	
	void update(Staff staff);
}
