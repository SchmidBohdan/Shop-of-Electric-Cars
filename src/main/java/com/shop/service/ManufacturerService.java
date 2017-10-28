package com.shop.service;

import java.util.List;

import com.shop.entity.Manufacturer;
import org.springframework.web.multipart.MultipartFile;

public interface ManufacturerService {

	void save(Manufacturer manufacturer, int countryId, MultipartFile image) throws Exception;

	List<Manufacturer> findAll();

	Manufacturer findOne(int id);

	void delete(int id);

	void update(Manufacturer manufacturer, int countryId, MultipartFile image) throws Exception;
}
