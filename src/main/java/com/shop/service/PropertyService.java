package com.shop.service;

import java.util.List;

import com.shop.entity.Property;
import com.shop.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;


public interface PropertyService {

	void save(Property property) throws Exception;

	List<Property> findAll();

	Property findOne(int id);

	void delete(int id);

	void update(Property property) throws Exception;
}
