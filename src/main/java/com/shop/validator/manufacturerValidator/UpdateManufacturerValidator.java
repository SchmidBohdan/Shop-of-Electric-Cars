package com.shop.validator.manufacturerValidator;

import com.shop.entity.Guarantee;
import com.shop.entity.Manufacturer;
import com.shop.validator.Validator;
import com.shop.validator.guaranteeValidator.UpdateGuaranteeValidatorMessages;
import org.springframework.stereotype.Component;

/**
 * Created by ooo on 7/2/2017.
 */
@Component
public class UpdateManufacturerValidator implements Validator {

    @Override
    public void validate(Object o) throws Exception {
        Manufacturer manufacturer = (Manufacturer) o;

        if(manufacturer.getName().isEmpty()){
            throw new ManufacturerException(UpdateManufacturerValidatorMessages.EMPTY_MANUFACTURERNAME);
        }else if(manufacturer.getDescription().isEmpty()){
            throw new ManufacturerException(UpdateManufacturerValidatorMessages.EMPTY_MANUFACTURERDESCRIPTION);
        }
    }
}
