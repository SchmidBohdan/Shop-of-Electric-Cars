package com.shop.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shop.entity.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProductDao extends JpaRepository<Product, Integer> {
    Product findByName(String name);
    Product findByDescription(String description);
    Product findByCurrency(String currency);

    @Query("select p from Product p left join fetch p.specefications where p.id=:id")
    Product speceficationWithProducts(@Param("id") int id);


}
