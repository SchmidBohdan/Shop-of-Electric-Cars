package com.shop.validator.propertyValidator;

import com.shop.dao.PropertyDao;
import com.shop.entity.Property;
import com.shop.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by ooo on 6/9/2017.
 */
@Component
public class PropertyValidator implements Validator {

    @Autowired
    private PropertyDao propertyDao;

    @Override
    public void validate(Object o) throws Exception {

        Property property = (Property) o;

        if(property.getName().isEmpty()){
            throw new PropertyException(PropertyValidatorMessages.EMPTY_PROPERTY_FIELD);
        }else if (propertyDao.findByName(property.getName()) != null) {
            throw new PropertyException(PropertyValidatorMessages.PROPERTY_ALREADY_EXIST);
        }

    }
}
