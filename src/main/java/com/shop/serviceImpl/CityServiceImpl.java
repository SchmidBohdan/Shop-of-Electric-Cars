package com.shop.serviceImpl;

import java.util.List;

import com.shop.dao.CountryDao;
import com.shop.entity.Country;
import com.shop.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.shop.dao.CityDao;
import com.shop.entity.City;
import com.shop.service.CityService;
@Service
public class CityServiceImpl implements CityService  {

	@Autowired
	private CityDao cityDao;
	@Autowired
	private CountryDao countryDao;

	@Autowired
	@Qualifier("cityValidator")
	private Validator validator;
	@Autowired
	@Qualifier("updateCityValidator")
	private Validator validatorUpdate;


	public void save(City city) throws Exception {
		validator.validate(city);
		cityDao.save(city);
		
	}

	public List<City> findAll() {
		
		return cityDao.findAll();
	}

	public City findOne(int id) {
		
		return cityDao.findOne(id);
	}

	public void delete(int id) {
		City city = cityDao.countryWithCities(id);

		for (Country country : city.getCountries()) {

            country.setCity(null);

			countryDao.saveAndFlush(country);

		}
		cityDao.delete(id);
	}

	public void update(City city) throws Exception {

		validatorUpdate.validate(city);
		cityDao.save(city);
		
	}

	@Override
	public City citiesWithCountries(int id) {
		return cityDao.citiesWithCountries(id);
	}

}
