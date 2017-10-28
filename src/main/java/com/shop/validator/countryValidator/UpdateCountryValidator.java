package com.shop.validator.countryValidator;

import com.shop.entity.Country;
import com.shop.validator.Validator;
import org.springframework.stereotype.Component;

/**
 * Created by ooo on 7/1/2017.
 */
@Component
public class UpdateCountryValidator implements Validator {



    public void validate(Object o) throws Exception {
        Country country = (Country) o;

        if(country.getName().isEmpty()){
            throw new UpdateCountryException(UpdateCountryValidatorMessager.EMPTY_COUNTRYNAME);
        }
    }

}
