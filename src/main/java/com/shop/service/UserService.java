package com.shop.service;

import java.util.List;

import com.shop.entity.User;


public interface UserService  {
	
	void save(User user, int sexId) throws Exception;
	
	List<User> findAll();
	
	User findOne(int id);
	
	void delete(int id); 
	
	void update(User user);

	User findByUuid(String uuid);

	User findUserWithSpecefication(int id);
	
}
