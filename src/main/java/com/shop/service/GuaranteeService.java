package com.shop.service;

import com.shop.entity.Guarantee;

import java.util.List;

/**
 * Created by ooo on 25.05.2017.
 */
public interface GuaranteeService {

    void save(Guarantee guarantee) throws Exception;
    List<Guarantee> findAll();
    Guarantee findOne(int id);
    void delete(int id);
    void update(Guarantee guarantee) throws Exception;


}
