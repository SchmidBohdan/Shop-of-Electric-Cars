package com.shop.dao;

import com.shop.entity.Guarantee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Created by ooo on 25.05.2017.
 */
public interface GuaranteeDao extends JpaRepository<Guarantee, Integer> {
    Guarantee findByGuaranteeTime(String name);

    @Query("select c from Guarantee c left join fetch c.products where c.id=:id")
    Guarantee productsWithGuarantee(@Param("id") int id);

}
