package com.shop.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shop.entity.Manufacturer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface ManufacturerDao extends JpaRepository<Manufacturer, Integer> {

    Manufacturer findByName(String name);
    Manufacturer findByDescription(String description);

    @Query("select m from Manufacturer m left join fetch m.products where m.id=:id")
    Manufacturer productsWithManufacturer(@Param("id") int id);
}
