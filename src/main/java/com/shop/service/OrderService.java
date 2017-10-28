package com.shop.service;

import java.security.Principal;
import java.util.List;

import com.shop.entity.Orders;


public interface OrderService {
	
	void save(Orders order);

	List<Orders> findAll();

	Orders findOne(int id);

	void delete(int id);

	void update(Orders order);

//	void buy(Principal principal, int id);

	void addIntoBusket(Principal principal, int id);

	void deleteFromBasket(int userId, int speceficationId);

	void buy(int userId);
}
