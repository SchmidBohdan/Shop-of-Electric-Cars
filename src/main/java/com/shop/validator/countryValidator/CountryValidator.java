package com.shop.validator.countryValidator;

import com.shop.dao.CountryDao;
import com.shop.entity.Country;
import com.shop.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by ooo on 6/7/2017.
 */
@Component
public class CountryValidator implements Validator {

    @Autowired
    private CountryDao countryDao;

    @Override
    public void validate(Object o) throws Exception {
        Country country = (Country) o;

        if(country.getName().isEmpty()){
            throw new CountryExсeption(CountryValidatorMessager.EMPTY_COUNTRYNAME_FIELD);
        }else if(countryDao.findByName(country.getName()) !=null){
            throw new CountryExсeption(CountryValidatorMessager.COUNTRYNAME_EXIST);
        }
    }
}
