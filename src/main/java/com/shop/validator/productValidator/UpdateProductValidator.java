package com.shop.validator.productValidator;

import com.shop.entity.Product;
import com.shop.validator.Validator;
import org.springframework.stereotype.Component;

/**
 * Created by ooo on 7/2/2017.
 */
@Component
public class UpdateProductValidator implements Validator {


        @Override
        public void validate (Object o) throws Exception {
            Product product = (Product) o;


            if(product.getName().isEmpty()) {
                throw new ProductExeption(UpdateProductValidatorMessages.EMPTY_PRODUCT_NAME);
            }else if (product.getDescription().isEmpty()){
                throw new ProductExeption(UpdateProductValidatorMessages.EMPTY_PRODUCT_DESCRIPTION);
            }else if (product.getPrice().isEmpty()) {
                throw new ProductExeption(UpdateProductValidatorMessages.EMPTY_PRODUCT_PRICE);
            }else if(!product.getPrice().matches("[0-9]+")){
                throw new ProductExeption(UpdateProductValidatorMessages.PRICE_NOTBE_WORD);
            }else if (product.getCurrency().isEmpty()) {
                throw new ProductExeption(UpdateProductValidatorMessages.EMPTY_PRODUCT_CURRENCY);
            }
        }
    }


