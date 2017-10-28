package com.shop.validator.cityValidator;


import com.shop.entity.City;
import com.shop.validator.Validator;
import org.springframework.stereotype.Component;

/**
 * Created by ooo on 6/5/2017.
 */
@Component
public class UpdateCityValidator implements Validator {


    @Override
    public  void validate(Object o) throws Exception{
        City city = (City) o;

        if(city.getName().isEmpty()){
            throw new UpdateCityExсeption(UpdateCityValidatorMessages.EMPTY_CITYNAME);
        }
    }
}
