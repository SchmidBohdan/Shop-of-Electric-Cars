package com.shop.serviceImpl;

import java.util.List;

import com.shop.dao.SpeceficationDao;
import com.shop.entity.Specefication;
import com.shop.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.shop.dao.SpeceficationTypeDao;
import com.shop.entity.SpeceficationType;
import com.shop.service.SpeceficationTypeService;
@Service
public class SpeceficationTypeServiceImpl implements SpeceficationTypeService {

	@Autowired
	private	SpeceficationTypeDao speceficationTypeDao;
	@Autowired
	private SpeceficationDao speceficationDao;
	@Autowired
	@Qualifier("speceficationTypeValidator")
	private Validator validator;
	@Autowired
	@Qualifier("updateSpeceficationTypeValidator")
	private Validator validatorUpdate;

	public void save(SpeceficationType speceficationType) throws Exception {

		validator.validate(speceficationType);
		speceficationTypeDao.save(speceficationType);

	}

	public List<SpeceficationType> findAll() {

		return speceficationTypeDao.findAll();
	}

	public SpeceficationType findOne(int id) {
		
		return speceficationTypeDao.findOne(id);
	}

	public void delete(int id) {
		SpeceficationType speceficationType = speceficationTypeDao.speceficationWithSpeceficationTypes(id);
		for(Specefication specefication : speceficationType.getSpecefications()){

			specefication.setSpeceficationType(null);

			speceficationDao.saveAndFlush(specefication);
		}
		speceficationTypeDao.delete(id);
		
	}

	public void update(SpeceficationType speceficationType) throws Exception {
		validatorUpdate.validate(speceficationType);
		speceficationTypeDao.save(speceficationType);
		
	}

}
