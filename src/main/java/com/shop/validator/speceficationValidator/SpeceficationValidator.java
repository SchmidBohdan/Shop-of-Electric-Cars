package com.shop.validator.speceficationValidator;



/**
 * Created by ooo on 6/25/2017.
 */

import com.shop.dao.SpeceficationDao;
import com.shop.entity.Specefication;
import com.shop.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SpeceficationValidator implements Validator{

    @Autowired
    private SpeceficationDao speceficationDao;


    @Override
    public void validate(Object o) throws Exception {

        Specefication specefication = (Specefication) o;

        if(specefication.getDescription().isEmpty()){
            throw new SpeceficationExeption(SpeceficationValidatorMessages.EMPTY_SPECEFICATION_DESCRIPTION_FIELD);
        }else if(speceficationDao.findByDescription(specefication.getDescription()) !=null){
            throw new SpeceficationExeption(SpeceficationValidatorMessages.SPECEFICATION_DESCRIPTION_EXIST);
        }
    }
}
