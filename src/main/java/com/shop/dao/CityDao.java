package com.shop.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.shop.entity.City;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CityDao extends JpaRepository<City, Integer>  {
    City findByName(String name);

    @Query("select distinct c from City c left join fetch c.countries where c.id=:id")
    City citiesWithCountries(@Param("id") int id);

    @Query("select c from City c left join fetch c.countries where c.id=:id")
    City countryWithCities(@Param("id") int id);
}
	