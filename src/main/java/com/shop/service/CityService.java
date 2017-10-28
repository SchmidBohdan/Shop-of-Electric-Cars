package com.shop.service;

import java.util.List;

import com.shop.entity.City;
import org.springframework.data.repository.query.Param;
public interface CityService {

	void save(City city) throws Exception;

	List<City> findAll();

	City findOne(int id);

	void delete(int id);

	void update(City city) throws Exception;

	City citiesWithCountries(int id);
}
