package com.shop.validator.propertyValidator;

import com.shop.entity.Property;
import com.shop.validator.Validator;
import org.springframework.stereotype.Component;

/**
 * Created by ooo on 7/2/2017.
 */
@Component
public class UpdatePropertyValidator implements Validator {


    @Override
    public void validate(Object o) throws Exception {

        Property property = (Property) o;

        if(property.getName().isEmpty()){
            throw new PropertyException(UpdatePropertyValidatorMessages.EMPTY_PROPERTY);
        }
    }
}
