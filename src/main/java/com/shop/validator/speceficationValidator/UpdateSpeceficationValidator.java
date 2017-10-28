package com.shop.validator.speceficationValidator;

import com.shop.entity.Specefication;
import com.shop.validator.Validator;
import org.springframework.stereotype.Component;


/**
 * Created by ooo on 7/2/2017.
 */
@Component
public class UpdateSpeceficationValidator implements Validator {


        @Override
        public void validate(Object o) throws Exception {
            Specefication specefication = (Specefication) o;

            if (specefication.getDescription().isEmpty()) {
                throw new SpeceficationExeption(UpdateSpeceficationValidatorMessages.EMPTY_SPECEFICATION_DESCRIPTION);
            }
        }
    }

