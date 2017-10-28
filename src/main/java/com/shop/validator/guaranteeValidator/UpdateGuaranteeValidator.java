package com.shop.validator.guaranteeValidator;

import com.shop.entity.Guarantee;
import com.shop.validator.Validator;
import org.hibernate.sql.Update;
import org.springframework.stereotype.Component;

/**
 * Created by ooo on 7/2/2017.
 */
@Component
public class UpdateGuaranteeValidator implements Validator {


    @Override
    public void validate(Object o) throws Exception {

        Guarantee guarantee = (Guarantee) o;

        if(guarantee.getGuaranteeTime().isEmpty()) {
            throw new GuaranteeExсeption(UpdateGuaranteeValidatorMessages.EMPTY_GUARANTEETIME);
        }else if(guarantee.getGuaranteeTime().matches("[0-9]*")==false){
            throw new GuaranteeExсeption(UpdateGuaranteeValidatorMessages.GUARANTEE_TIME_NOTWORD_ONLY_NUMBER);
        }

    }
}
