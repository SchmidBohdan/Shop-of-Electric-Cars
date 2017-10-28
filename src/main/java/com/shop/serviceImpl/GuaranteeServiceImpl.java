package com.shop.serviceImpl;

import com.shop.dao.GuaranteeDao;
import com.shop.dao.ProductDao;
import com.shop.entity.Guarantee;
import com.shop.entity.Product;
import com.shop.service.GuaranteeService;
import com.shop.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ooo on 25.05.2017.
 */
@Service
public class GuaranteeServiceImpl implements GuaranteeService {

    @Autowired
    private GuaranteeDao guaranteeDao;
    @Autowired
    private ProductDao productDao;
    @Autowired
    @Qualifier("guaranteeValidator")
    private Validator validator;
    @Autowired
    @Qualifier("updateGuaranteeValidator")
    private Validator validatorUpdate;


    @Override
    public void save(Guarantee guarantee) throws Exception {
        validator.validate(guarantee);
        guaranteeDao.save(guarantee);
    }

    @Override
    public List<Guarantee> findAll() {
        return guaranteeDao.findAll();
    }

    @Override
    public Guarantee findOne(int id) {
        return guaranteeDao.findOne(id);
    }

    @Override
    public void delete(int id) {
    Guarantee guarantee = guaranteeDao.productsWithGuarantee(id);

        for (Product product : guarantee.getProducts()) {

            product.setGuarantees(null);

            productDao.saveAndFlush(product);
        }

        guaranteeDao.delete(id);
    }

    @Override
    public void update(Guarantee guarantee) throws  Exception {
        validatorUpdate.validate(guarantee);
        guaranteeDao.save(guarantee);
    }
}
