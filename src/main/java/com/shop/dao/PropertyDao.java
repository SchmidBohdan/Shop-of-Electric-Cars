package com.shop.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shop.entity.Property;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PropertyDao extends JpaRepository<Property, Integer> {
    Property findByName(String name);

    @Query("select p from Property p left join fetch p.specefications where p.id=:id")
    Property speceficationWithProperties(@Param("id") int id);
}
