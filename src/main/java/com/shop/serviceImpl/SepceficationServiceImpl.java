package com.shop.serviceImpl;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.shop.dao.ProductDao;
import com.shop.dao.PropertyDao;
import com.shop.dao.SpeceficationTypeDao;
import com.shop.entity.Product;
import com.shop.entity.Property;
import com.shop.entity.SpeceficationType;
import com.shop.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;

import com.shop.dao.SpeceficationDao;
import com.shop.entity.Specefication;
import com.shop.service.SpeceficationService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


@Service
public class SepceficationServiceImpl implements SpeceficationService {

	@Autowired
	private SpeceficationDao speceficationDao;
	@Autowired
	private ProductDao productDao;
	@Autowired
	private PropertyDao propertyDao;
	@Autowired
	private SpeceficationTypeDao speceficationTypeDao;
	@Autowired
	@Qualifier("speceficationValidator")
	private Validator validator;
	@Autowired
	@Qualifier("updateSpeceficationValidator")
	private Validator validatorUpdate;
	
	public void save(Specefication specefication, int productid, int propertyid, int speceficationTypeid,
					 MultipartFile image) throws Exception {

		validator.validate(specefication);
		Product product = productDao.findOne(productid);
		Property property = propertyDao.findOne(propertyid);
		SpeceficationType speceficationType = speceficationTypeDao.findOne(speceficationTypeid);

		speceficationDao.saveAndFlush(specefication);

		specefication.setProduct(product);
		specefication.setProperty(property);
		specefication.setSpeceficationType(speceficationType);

		String path = System.getProperty("catalina.home") + "/resources/" + specefication.getDescription() + "/"
				+ image.getOriginalFilename();

		specefication.setPathImage("resources/" +specefication.getDescription() + "/"
				+ image.getOriginalFilename());

		File filePath = new File(path);
		try{
			filePath.mkdirs();
			image.transferTo(filePath);
		}catch (IOException e){
			System.out.println("error with file");
		}

		speceficationDao.save(specefication);

	}

	public List<Specefication> findAll() {
		
		return speceficationDao.findAll();
	}

	public Specefication findOne(int id) {
		
		return speceficationDao.findOne(id);
	}

	public void delete(int id) {
		speceficationDao.delete(id);
		
	}

	public void update(Specefication specefication, int productId, int propertyId, int speceficationTypeId,
					   MultipartFile image) throws Exception {

		validatorUpdate.validate(specefication);
		Product product = productDao.findOne(productId);
		Property property = propertyDao.findOne(propertyId);
		SpeceficationType speceficationType = speceficationTypeDao.findOne(speceficationTypeId);

		specefication.setProduct(product);
		specefication.setProperty(property);
		specefication.setSpeceficationType(speceficationType);

		String path = System.getProperty("catalina.home") + "/resources/"
				+ specefication.getDescription() + "/" + image.getOriginalFilename();

		specefication.setPathImage("resources/" + specefication.getDescription() + "/"
				+ image.getOriginalFilename());

		File filePath = new File(path);
		try{
			filePath.mkdirs();
			image.transferTo(filePath);
		}catch (IOException e){
			System.out.println("error with file");
		}

		speceficationDao.save(specefication);

	}

	@Override
	public Specefication speceficationsWithproduct(int id) {
		return speceficationDao.speceficationsWithproduct(id);
	}

	@Override
	public Page<Specefication> findAllPages(Pageable pageable) {
		return speceficationDao.findAll(pageable);
	}

}
