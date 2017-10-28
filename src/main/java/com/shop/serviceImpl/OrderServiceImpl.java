package com.shop.serviceImpl;

import java.security.Principal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.shop.dao.SpeceficationDao;
import com.shop.dao.UserDao;
import com.shop.entity.Specefication;
import com.shop.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shop.dao.OrderDao;
import com.shop.entity.Orders;
import com.shop.service.OrderService;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderDao orderDao;
	@Autowired
	private UserDao userDao;
	@Autowired
	private SpeceficationDao speceficationDao;
	
	public void save(Orders order) {
		orderDao.save(order);
		
	}

	public List<Orders> findAll() {
		
		return orderDao.findAll();
	}

	public Orders findOne(int id) {
		
		return orderDao.findOne(id);
	}

	public void delete(int id) {
		orderDao.delete(id);
		
	}

	public void update(Orders order) {
		orderDao.save(order);
		
	}

//	@Override
//	public void addIntoBucket(Principal principal, int id) {
//
//		Orders orders = new Orders();
//
//		orders.setDate(LocalDate.now());
//
//		User user = userDao.findOne(Integer.parseInt(principal.getName()));
//
////		user.getOrders().add(orders);
//		orders.setUser(user);
//
//		Specefication specefication = speceficationDao.findOne(id);
//
//		orders.getSpecefications().add(specefication);
//
//
//		orderDao.save(orders);
//
//}

    @Override
    public void addIntoBusket(Principal principal, int id) {

        User user = userDao.findUserWithSpecefications(Integer.parseInt(principal.getName()));

        Specefication specefication = speceficationDao.findOne(id);

        user.getSpecefications().add(specefication);

        userDao.save(user);

    }

	@Override
	@Transactional
	public void deleteFromBasket(int userId, int speceficationId) {

		User user = userDao.findUserWithSpecefications(userId);
		Specefication specefication = speceficationDao.findOne(speceficationId);

		user.getSpecefications().remove(specefication);

		userDao.save(user);
	}

	@Override
	@Transactional
	public void buy(int userId) {
		Orders orders = new Orders(LocalDateTime.now());
		orderDao.saveAndFlush(orders);
		User user = userDao.findUserWithSpecefications(userId);
		orders.setUser(user);

		for (Specefication specefication : user.getSpecefications()) {

			orders.getSpecefications().add(specefication);

			orderDao.save(orders);

		}
		user.getSpecefications().clear();
		userDao.save(user);
	}

}
