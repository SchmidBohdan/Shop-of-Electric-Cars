package com.shop.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shop.entity.Staff;

public interface StaffDao extends JpaRepository<Staff, Integer> {

}
