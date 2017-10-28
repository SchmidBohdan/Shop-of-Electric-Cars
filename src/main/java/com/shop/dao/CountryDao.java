package com.shop.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.shop.entity.Country;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface CountryDao extends JpaRepository<Country, Integer> {
	Country findByName(String name);



	@Query("select c from Country c left join fetch c.city where c.id=:id")
	Country countriesWithCities(@Param("id") int id);

	@Query("select c from Country c left join fetch c.manufacturers where c.id=:id")
	Country manufactoryWithCountries(@Param("id") int id);

}
	
