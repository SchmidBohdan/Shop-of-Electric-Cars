package com.shop.service;

import java.util.List;

import com.shop.entity.City;
import com.shop.entity.Country;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface CountryService {
	
	void save(Country country, int cityId) throws Exception;

	List<Country> findAll();

	Country findOne(int id);

	void delete(int id);

	void update(Country country, int cityId) throws Exception;

	Country countriesWithCities(int id);

//	Page<Country> findAllPages(Pageable pegeable);

}
