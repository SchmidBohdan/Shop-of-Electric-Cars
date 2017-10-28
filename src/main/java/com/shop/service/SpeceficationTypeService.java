package com.shop.service;

import java.util.List;

import com.shop.entity.SpeceficationType;


public interface SpeceficationTypeService {

	void save(SpeceficationType speceficationType) throws Exception;

	List<SpeceficationType> findAll();

	SpeceficationType findOne(int id);

	void delete(int id);

	void update(SpeceficationType speceficationType) throws Exception;
}
