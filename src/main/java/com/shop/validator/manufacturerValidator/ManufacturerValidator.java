package com.shop.validator.manufacturerValidator;

import com.shop.dao.ManufacturerDao;
import com.shop.entity.Manufacturer;
import com.shop.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by ooo on 6/24/2017.
 */
@Component
public class ManufacturerValidator implements Validator {

    @Autowired
    private ManufacturerDao manufacturerDao;

    @Override
    public void validate(Object o) throws Exception {
        Manufacturer manufacturer = (Manufacturer) o;

        if(manufacturer.getName().isEmpty()){
            throw new ManufacturerException(ManufacturerValidatorMessages.EMPTY_MANUFACTURERNAME_FIELD);
        }else if(manufacturerDao.findByName(manufacturer.getName()) != null){
            throw new ManufacturerException((ManufacturerValidatorMessages.MANUFACTURERNAME_EXIST));
        }else if(manufacturer.getDescription().isEmpty()){
            throw new ManufacturerException((ManufacturerValidatorMessages.EMPTY_MANUFACTURERDESCRIPTION_FIELD));
        }else if(manufacturerDao.findByDescription(manufacturer.getDescription()) != null){
            throw new ManufacturerException((ManufacturerValidatorMessages.MANUFACTURERDESCRIPTION_EXIST));
        }
    }
}
