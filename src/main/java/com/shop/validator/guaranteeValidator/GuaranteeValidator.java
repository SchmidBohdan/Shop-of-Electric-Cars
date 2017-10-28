package com.shop.validator.guaranteeValidator;

import com.shop.dao.GuaranteeDao;
import com.shop.entity.Guarantee;
import com.shop.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by ooo on 6/22/2017.
 */
@Component
public class GuaranteeValidator implements Validator {

        @Autowired
        private GuaranteeDao guaranteeDao;

        @Override
        public void validate(Object o) throws Exception {
            Guarantee guarantee = (Guarantee) o;


             if(guarantee.getGuaranteeTime().isEmpty()) {
                 throw new GuaranteeExсeption(GuaranteeValidatorMessages.EMPTY_GUARANTEETIME_FIELD);
             }else if(guaranteeDao.findByGuaranteeTime(guarantee.getGuaranteeTime()) != null) {
                 throw new GuaranteeExсeption(GuaranteeValidatorMessages.GUARANTEETIME_EXIST);
             }else if(guarantee.getGuaranteeTime().matches("[0-9]*")==false){
                 throw new GuaranteeExсeption(GuaranteeValidatorMessages.GUARANTEETIME_NOTWORDONLYNUMBER);
             }
    }

}
