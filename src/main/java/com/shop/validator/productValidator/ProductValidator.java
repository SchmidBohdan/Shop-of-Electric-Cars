package com.shop.validator.productValidator;

import com.shop.dao.ProductDao;
import com.shop.entity.Product;
import com.shop.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by ooo on 6/25/2017.
 */
@Component
public class ProductValidator implements Validator {

    @Autowired
    private ProductDao productDao;

    @Override
    public void validate(Object o) throws Exception {
        Product product = (Product) o;

        if(product.getName().isEmpty()){
            throw new ProductExeption(ProductValidatorMessages.EMPTY_PRODUCT_NAME_FIELD);
        }else if(productDao.findByName(product.getName()) != null){
            throw new ProductExeption(ProductValidatorMessages.PRODUCT_NAME_EXIST);
        }else if(product.getDescription().isEmpty()){
            throw new ProductExeption(ProductValidatorMessages.EMPTY_PRODUCT_DESCRIPTION_FIELD);
        }else if(productDao.findByDescription(product.getDescription()) != null){
            throw new ProductExeption(ProductValidatorMessages.PRODUCT_DESCRIPTION_EXIST);
        }else if(product.getPrice().isEmpty()){
            throw new ProductExeption(ProductValidatorMessages.EMPTY_PRODUCT_PRICE_FIELD);
        }else if(product.getCurrency().isEmpty()){
            throw new ProductExeption(ProductValidatorMessages.EMPTY_PRODUCT_CURRENCY_FIELD);
        }
    }
}