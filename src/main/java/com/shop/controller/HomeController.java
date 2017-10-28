package com.shop.controller;

import com.shop.dao.SpeceficationDao;
import com.shop.service.ProductService;
import com.shop.service.SpeceficationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

	@Autowired
	private ProductService productService;
	@Autowired
	private SpeceficationService speceficationService;


//	OLD method with RecuestMapping
//	@RequestMapping(value="/", method=RequestMethod.GET)
//	public String home() {
//		return "home";
//	}

	@GetMapping("/")
	public String home(Model model, @PageableDefault Pageable pageable) {
		model.addAttribute("specefications",  speceficationService.findAllPages(pageable));
		model.addAttribute("products",  productService.findAll());
		return "home";
	}

	@PostMapping("/")
	public String homeAfterLogin(Model model, @PageableDefault Pageable pageable) {
		model.addAttribute("specefications", speceficationService.findAllPages(pageable));
		return "home";
	}

	@GetMapping("/aboutUs")
	public String aboutUs() {
		return "aboutUs";
	}

	@GetMapping("/login")
	public String log(Model model, @PageableDefault Pageable pageable ) {
		model.addAttribute("specefications",  speceficationService.findAllPages(pageable));
		model.addAttribute("products",  productService.findAll());
		return "home";
	}

	@GetMapping("/homeList")
	public String homeList(Model model, @PageableDefault Pageable pageable) {
		model.addAttribute("specefications",  speceficationService.findAllPages(pageable));
		model.addAttribute("products",  productService.findAll());
		return "homeList";
	}
}
