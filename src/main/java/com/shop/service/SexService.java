package com.shop.service;

import java.util.List;

import com.shop.entity.Sex;



public interface SexService {
	
	void save( Sex  sex);

	List< Sex> findAll();

	 Sex findOne(int id);

	void delete(int id);

	void update( Sex  sex);
}
