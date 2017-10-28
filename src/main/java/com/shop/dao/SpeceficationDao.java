package com.shop.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shop.entity.Specefication;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SpeceficationDao extends JpaRepository<Specefication, Integer> {
    Specefication findByDescription(String description);

    @Query("select s from Specefication s left join fetch s.product where s.id=:id")
    Specefication speceficationsWithproduct(@Param("id") int id);

//    @Query("select m from Manufacturer m left join fetch m.products where m.id=:id")
//    Manufacturer productsWithManufacturer(@Param("id") int id);
//
//    @Query("select m from Manufacturer m left join fetch m.products where m.id=:id")
//    Manufacturer productsWithManufacturer(@Param("id") int id);

}
