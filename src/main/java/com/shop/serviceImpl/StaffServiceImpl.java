package com.shop.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.dao.StaffDao;

import com.shop.entity.Staff;
import com.shop.service.StaffService;
@Service
public class StaffServiceImpl implements StaffService {

	@Autowired
	private StaffDao staffDao;
	
	public void save(Staff staff) {
		staffDao.save(staff);
		
	}

	public List<Staff> findAll() {
		
		return staffDao.findAll();
	}

	public Staff findOne(int id) {
		
		return staffDao.findOne(id);
	}

	public void delete(int id) {
		staffDao.delete(id);
		
	}

	public void update(Staff staff) {
		staffDao.save(staff);
		
	}

}
