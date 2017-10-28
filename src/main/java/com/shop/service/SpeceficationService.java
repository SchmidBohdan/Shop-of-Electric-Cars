package com.shop.service;

import java.util.List;

import com.shop.entity.Specefication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;


public interface SpeceficationService {
	
	void save(Specefication specefication, int productId, int propertyId, int speceficationTypeId,
			  MultipartFile image) throws Exception;

	List<Specefication> findAll();

	Specefication findOne(int id);

	void delete(int id);

	void update(Specefication specefication, int productId, int propertyId, int speceficationTypeId,
				MultipartFile image) throws Exception;

	Specefication speceficationsWithproduct(int id);

	Page<Specefication> findAllPages(Pageable pageable);
}
