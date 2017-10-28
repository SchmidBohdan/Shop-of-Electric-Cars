package com.shop.serviceImpl;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.shop.dao.CountryDao;
import com.shop.dao.ProductDao;
import com.shop.entity.Country;
import com.shop.entity.Product;
import com.shop.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.shop.dao.ManufacturerDao;
import com.shop.entity.Manufacturer;
import com.shop.service.ManufacturerService;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ManufacturerServiceImpl implements ManufacturerService {

	@Autowired
	private ManufacturerDao manufacturerDao;
	@Autowired
	private CountryDao countryDao;
	@Autowired
	private ProductDao productDao;
	@Autowired
	@Qualifier("manufacturerValidator")
	private Validator validator;
	@Autowired
	@Qualifier("updateManufacturerValidator")
	private Validator validatorUpdate;
	
	public void save(Manufacturer manufacturer, int countryId, MultipartFile image) throws Exception {

		validator.validate(manufacturer);
		Country country = countryDao.findOne(countryId);

		manufacturerDao.saveAndFlush(manufacturer);

		manufacturer.setCountry(country);

		String path = System.getProperty("catalina.home") + "/resources/"
				+ manufacturer.getName() + "/" + image.getOriginalFilename();

		manufacturer.setPathImage("resources/" + manufacturer.getName() + "/"
		 + image.getOriginalFilename());

		File filePath = new File(path);
		try{
			filePath.mkdirs();
			image.transferTo(filePath);
		}catch (IOException e){
			System.out.println("error with file");
		}

		manufacturerDao.save(manufacturer);
		
	}

	public List<Manufacturer> findAll() {
		
		return manufacturerDao.findAll();
	}

	public Manufacturer findOne(int id) {
		
		return manufacturerDao.findOne(id);
	}

	public void delete(int id) {
		Manufacturer manufacturer = manufacturerDao.productsWithManufacturer(id);

		for (Product product : manufacturer.getProducts()) {

			product.setManufacturer(null);

			productDao.saveAndFlush(product);
		}
		manufacturerDao.delete(id);
		
	}

	public void update(Manufacturer manufacturer, int countryId, MultipartFile image) throws Exception {

		validatorUpdate.validate(manufacturer);
		Country country = countryDao.findOne(countryId);

		manufacturer.setCountry(country);

		String path = System.getProperty("catalina.home") + "/resources/"
				+ manufacturer.getName() + "/" + image.getOriginalFilename();

		manufacturer.setPathImage("resources/" + manufacturer.getName() + "/"
				+ image.getOriginalFilename());

		File filePath = new File(path);
		try{
			filePath.mkdirs();
			image.transferTo(filePath);
		}catch (IOException e){
			System.out.println("error with file");
		}

		manufacturerDao.save(manufacturer);


		
	}
	
}
