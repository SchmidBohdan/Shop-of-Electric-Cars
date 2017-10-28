package com.shop.serviceImpl;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.shop.dao.GuaranteeDao;
import com.shop.dao.ManufacturerDao;
import com.shop.dao.SpeceficationDao;
import com.shop.entity.Guarantee;
import com.shop.entity.Manufacturer;
import com.shop.entity.Specefication;
import com.shop.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.shop.dao.ProductDao;
import com.shop.entity.Product;
import com.shop.service.ProductService;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductDao productDao;
	@Autowired
	private ManufacturerDao manufacturerDao;
	@Autowired
	private GuaranteeDao guaranteeDao;
	@Autowired
	private SpeceficationDao speceficationDao;
	@Autowired
	@Qualifier("productValidator")
	private Validator validator;
	@Autowired
	@Qualifier("updateProductValidator")
	private Validator validatorUpdate;



	public void save(Product product, int manufacturerId, int guaranteeId) throws Exception {

		validator.validate(product);
		Manufacturer manufacturer = manufacturerDao.findOne(manufacturerId);
		Guarantee guarantee = guaranteeDao.findOne(guaranteeId);

		product.setManufacturer(manufacturer);
		product.setGuarantees(guarantee);

		productDao.saveAndFlush(product);

//		String path = System.getProperty("catalina.home") + "/resources/"
//		 				+ product.getName() + "/" + img.getOriginalFilename();
//
//
//		product.setPathImg("resources/" + product.getName() + "/" + img.getOriginalFilename());
//
//
//		File filePath = new File(path);
//
//		 		try {
//			 			filePath.mkdirs();
//					img.transferTo(filePath);
//				} catch (IOException e) {
//					System.out.println("error with file");
//			 		}


		productDao.save(product);
	}

	public List<Product> findAll() {
	    return productDao.findAll();
	}

	public Product findOne(int id) {
		
		return productDao.findOne(id);
	}

	public void delete(int id) {
		Product product = productDao.speceficationWithProducts(id);

		for(Specefication specefication : product.getSpecefications()) {

			specefication.setProduct(null);

			speceficationDao.saveAndFlush(specefication);
		}
		productDao.delete(id);
		
	}

	public void update(Product product, int manufacturerId, int guaranteeId) throws Exception {

		validatorUpdate.validate(product);
		Manufacturer manufacturer = manufacturerDao.findOne(manufacturerId);
		Guarantee guarantee = guaranteeDao.findOne(guaranteeId);

		product.setManufacturer(manufacturer);
		product.setGuarantees(guarantee);

		productDao.save(product);
		
	}
	
}
