package com.shop.service;

import java.util.List;

import com.shop.entity.Product;
import org.springframework.web.multipart.MultipartFile;

public interface ProductService {

	void save(Product product, int manufacturerId, int guaranteeId) throws Exception;

	List<Product> findAll();

	Product findOne(int id);

	void delete(int id);

	void update(Product product, int manufacturerId, int guaranteeId) throws Exception;
}
