package com.shop.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.dao.SexDao;
import com.shop.entity.Sex;
import com.shop.service.SexService;
@Service
public class SexServiceImpl implements SexService {

	@Autowired
	private SexDao sexDao;
	
	public void save(Sex sex) {
		 sexDao.save(sex);
		
	}

	public List<Sex> findAll() {
		
		return  sexDao.findAll();
	}

	public Sex findOne(int id) {
		
		return  sexDao.findOne(id);
	}

	public void delete(int id) {
		sexDao.delete(id);
		
	}

	public void update(Sex sex) {
		 sexDao.save(sex);
		
	}

}
