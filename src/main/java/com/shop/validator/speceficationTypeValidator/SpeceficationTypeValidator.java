package com.shop.validator.speceficationTypeValidator;

import com.shop.dao.SpeceficationTypeDao;
import com.shop.entity.SpeceficationType;
import com.shop.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by ooo on 6/22/2017.
 */
@Component
public class SpeceficationTypeValidator implements Validator {

    @Autowired
    private SpeceficationTypeDao speceficationTypeDao;


    @Override
    public void validate(Object o) throws Exception {
        SpeceficationType speceficationType = (SpeceficationType) o;

        if (speceficationType.getName().isEmpty()) {
            throw new SpeceficationTypeExeption(SpeceficationTypeValidatorMessages.EMPTY_SPECEFICATIONTYPE_FIELD);
        }else if(speceficationTypeDao.findByName(speceficationType.getName()) != null){
            throw new SpeceficationTypeExeption(SpeceficationTypeValidatorMessages.SPECEFICATIONTYPE_EXIST);
        }

        }
    }
