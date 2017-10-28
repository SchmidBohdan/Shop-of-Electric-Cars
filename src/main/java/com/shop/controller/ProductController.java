package com.shop.controller;

import com.shop.entity.Guarantee;
import com.shop.entity.Manufacturer;
import com.shop.entity.Property;
import com.shop.service.GuaranteeService;
import com.shop.service.ManufacturerService;
import com.shop.validator.productValidator.ProductValidatorMessages;
import com.shop.validator.productValidator.UpdateProductValidatorMessages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.shop.entity.Product;
import com.shop.service.ProductService;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class ProductController {
	
	@Autowired
	private ProductService productService;
	@Autowired
	private ManufacturerService manufacturerService;
	@Autowired
	public GuaranteeService guaranteeService;
	
	@GetMapping("/product")
	public String product(Model model){
		model.addAttribute("products", productService.findAll());
		model.addAttribute("manufacturers", manufacturerService.findAll());
		model.addAttribute("guaranties", guaranteeService.findAll());
		model.addAttribute("product", new Product());
		return "product";
	}

	@PostMapping("/product")
	public String product(@ModelAttribute Product product, @RequestParam int manufacturerId,
						  @RequestParam int guaranteeId, Model model){
		Manufacturer manufacturer = manufacturerService.findOne(manufacturerId);
		Guarantee guarantee = guaranteeService.findOne(guaranteeId);
		product.setManufacturer(manufacturer);
		product.setGuarantees(guarantee);
		try {
			productService.save(product, manufacturerId, guaranteeId);
		}catch (Exception e) {
			if (e.getMessage().equals(ProductValidatorMessages.EMPTY_PRODUCT_NAME_FIELD) ||
					e.getMessage().equals(ProductValidatorMessages.PRODUCT_NAME_EXIST)) {
				model.addAttribute("productNameException", e.getMessage());
			}else if(e.getMessage().equals(ProductValidatorMessages.EMPTY_PRODUCT_DESCRIPTION_FIELD) ||
					e.getMessage().equals(ProductValidatorMessages.PRODUCT_DESCRIPTION_EXIST)){
				model.addAttribute("productDescriptionException", e.getMessage());
			}else if(e.getMessage().equals(ProductValidatorMessages.EMPTY_PRODUCT_PRICE_FIELD)){
				model.addAttribute("productPriceException", e.getMessage());
			}else if(e.getMessage().equals(ProductValidatorMessages.EMPTY_PRODUCT_CURRENCY_FIELD)) {
				model.addAttribute("productCurrencyException", e.getMessage());
			}

			model.addAttribute("products", productService.findAll());
			model.addAttribute("manufacturers", manufacturerService.findAll());
			model.addAttribute("guaranties", guaranteeService.findAll());

			return "product";
		}
		return "redirect:/product";
	}

	@GetMapping("/deleteProduct/{id}")
	private String deleteProduct(@PathVariable int id){

		productService.delete(id);

		return "redirect:/product";
	}

	@GetMapping("/updateProduct/{id}")
	public String updateProduct(@PathVariable int id, Model model){
		Product product = productService.findOne(id);
		model.addAttribute("currentProduct", product);
		model.addAttribute("manufacturers", manufacturerService.findAll());
		model.addAttribute("guaranties", guaranteeService.findAll());
		return "updateProduct";
	}
	@PostMapping("/updateProduct/{id}")
	public String updateProduct(@PathVariable int id, @RequestParam String name,
								@RequestParam String description,
								@RequestParam String price,
								@RequestParam String currency,
								@RequestParam int manufacturerId,
								@RequestParam int guaranteeId, Model model) throws Exception{

		Product product = productService.findOne(id);
		try {
				product.setName(name);
				product.setDescription(description);
				product.setPrice(price);
				product.setCurrency(currency);

			productService.update(product, manufacturerId, guaranteeId);
		}catch (Exception e) {
			if (e.getMessage().equals(UpdateProductValidatorMessages.EMPTY_PRODUCT_NAME)) {
				model.addAttribute("updateProductNameException", e.getMessage());
			}else if(e.getMessage().equals(UpdateProductValidatorMessages.EMPTY_PRODUCT_DESCRIPTION)){
				model.addAttribute("updateProductDescriptionException", e.getMessage());
			}
			else if(e.getMessage().equals(UpdateProductValidatorMessages.EMPTY_PRODUCT_PRICE) ||
					e.getMessage().equals(UpdateProductValidatorMessages.PRICE_NOTBE_WORD)){
				model.addAttribute("updateProductPriceException", e.getMessage());
			}
			else if(e.getMessage().equals(UpdateProductValidatorMessages.EMPTY_PRODUCT_CURRENCY)) {
				model.addAttribute("updateProductCurrencyException", e.getMessage());
			}
			model.addAttribute("currentProduct", product);
			model.addAttribute("manufacturers", manufacturerService.findAll());
			model.addAttribute("guaranties", guaranteeService.findAll());
			return "updateProduct";
		}
		return "redirect:/product";
	}

}
