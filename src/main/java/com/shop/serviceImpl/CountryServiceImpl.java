package com.shop.serviceImpl;

import java.util.List;

import com.shop.dao.ManufacturerDao;
import com.shop.entity.Manufacturer;
import com.shop.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.shop.dao.CityDao;
import com.shop.dao.CountryDao;
import com.shop.entity.City;
import com.shop.entity.Country;
import com.shop.service.CountryService;
@Service
public class CountryServiceImpl implements CountryService {

	@Autowired
	private CountryDao countryDao;
	@Autowired
	private CityDao cityDao;
	@Autowired
	@Qualifier("countryValidator")
	private Validator validator;
	@Autowired
	@Qualifier("updateCountryValidator")
	private Validator validatorUpdate;
	@Autowired
	private ManufacturerDao manufacturerDao;


	
	public void save(Country country, int cityid) throws Exception {

		validator.validate(country);
		City city = cityDao.findOne(cityid);

//		cityDao.saveAndFlush(city);

		countryDao.saveAndFlush(country);

		country.setCity(city);

		countryDao.save(country);
		
	}

	public List<Country> findAll() {
		
		return countryDao.findAll();
	}

	public Country findOne(int id) {
		
		return countryDao.findOne(id);
	}

	public void delete(int id) {
	Country country = countryDao.manufactoryWithCountries(id);

		for (Manufacturer manufacturer : country.getManufacturers()) {

			manufacturer.setCountry(null);

			manufacturerDao.saveAndFlush(manufacturer);
		}
		countryDao.delete(id);
		
	}

	public void update(Country country, int cityId) throws Exception {

		validatorUpdate.validate(country);
		City city = cityDao.findOne(cityId);

		country.setCity(city);

		countryDao.save(country);
		
	}

	@Override
	public Country countriesWithCities(int id) {
		return countryDao.countriesWithCities(id);
	}

//	@Override
//	public Page<Country> findAllPages(Pageable pegeable) {
//		return countryDao.findAll(pegeable);
//	}


}
