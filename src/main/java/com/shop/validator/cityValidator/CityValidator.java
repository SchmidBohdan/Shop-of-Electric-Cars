package com.shop.validator.cityValidator;

import com.shop.dao.CityDao;
import com.shop.entity.City;
import com.shop.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by ooo on 6/5/2017.
 */
@Component
public class CityValidator implements Validator {

    @Autowired
    private CityDao cityDao;

    @Override
    public  void validate(Object o) throws Exception{
        City city = (City) o;

        if(city.getName().isEmpty()){
            throw new CityExсeption(CityValidatorMessages.EMPTY_CITYNAME_FIELD);
        }else if (cityDao.findByName(city.getName()) != null) {
            throw new CityExсeption(CityValidatorMessages.CITYNAME_EXIST);
        }
    }
}
