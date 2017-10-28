package com.shop.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shop.entity.SpeceficationType;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface SpeceficationTypeDao extends JpaRepository<SpeceficationType, Integer> {
    SpeceficationType findByName(String name);

    @Query("select s from SpeceficationType s left join fetch s.specefications where s.id=:id")
    SpeceficationType speceficationWithSpeceficationTypes(@Param("id") int id);
}
