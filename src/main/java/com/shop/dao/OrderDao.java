package com.shop.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shop.entity.Orders;

public interface OrderDao extends JpaRepository<Orders, Integer>{
	
}
