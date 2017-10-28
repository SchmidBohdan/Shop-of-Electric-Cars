package com.shop.serviceImpl;

import java.util.List;

import com.shop.dao.SpeceficationDao;
import com.shop.entity.Specefication;
import com.shop.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.shop.dao.PropertyDao;
import com.shop.entity.Property;
import com.shop.service.PropertyService;
@Service
public class PropertyServiceImpl implements PropertyService {

	@Autowired
	private PropertyDao propertyDao;
	@Autowired
	private SpeceficationDao speceficationDao;
	@Autowired
	@Qualifier("propertyValidator")
	private Validator validator;
	@Autowired
	@Qualifier("updatePropertyValidator")
	private Validator validatorUpdate;

	public void save(Property property) throws Exception {
		validator.validate(property);
		propertyDao.save(property);
		
	}

	public List<Property> findAll() {
		
		return propertyDao.findAll();
	}

	public Property findOne(int id) {
		
		return propertyDao.findOne(id);
	}

	public void delete(int id) {
		Property property = propertyDao.speceficationWithProperties(id);
		for (Specefication specefication :property.getSpecefications()) {

			specefication.setProperty(null);

			speceficationDao.saveAndFlush(specefication);
		}
		propertyDao.delete(id);
		
	}

	public void update(Property property) throws Exception {
		validatorUpdate.validate(property);
		propertyDao.save(property);
		
	}

}
