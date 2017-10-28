package com.shop.controller;

import com.shop.entity.City;
import com.shop.validator.countryValidator.CountryValidatorMessager;
import com.shop.validator.countryValidator.UpdateCountryValidatorMessager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.shop.entity.Country;
import com.shop.service.CityService;
import com.shop.service.CountryService;

import java.awt.print.Pageable;

@Controller
public class CountryController {

	@Autowired
	private CountryService countryService;
	@Autowired
	private  CityService cityService;

	@GetMapping("/country")
	public String country(Model model){
		model.addAttribute("countries", countryService.findAll());
		model.addAttribute("cities", cityService.findAll());
//		model.addAttribute("country", countryService.findOne(id));

		return "country";
	}

	@PostMapping("/country")
	public String country(@RequestParam String name, @RequestParam int cityId, Model model){

		City city = cityService.findOne(cityId);
		Country country = new Country();

		country.setName(name);
		country.setCity(city);

		try {

			countryService.save(country, cityId);

			}catch (Exception e){
			if(e.getMessage().equals(CountryValidatorMessager.EMPTY_COUNTRYNAME_FIELD) ||
					e.getMessage().equals(CountryValidatorMessager.COUNTRYNAME_EXIST)){
				model.addAttribute("countryNameException", e.getMessage());
			}
					model.addAttribute("cities", cityService.findAll());
		            model.addAttribute("countries", countryService.findAll());
//			if (e.getMessage().equals(UpdateCountryValidatorMessager.EMPTY_COUNTRYNAME_FIELD)){
//				model.addAttribute("countryNameEmpties", e.getMessage());
//			}else if(e.getMessage().equals(UpdateCountryValidatorMessager.COUNTRYNAME_EXIST)){
//				model.addAttribute("countryNameExists", e.getMessage());
//			}
				return "country";

		}
		return "redirect:/country";
	}

	@GetMapping("/deleteCountry/{id}")
	public String deleteCountry(@PathVariable int id){

		countryService.delete(id);

		return "redirect:/country";
	}

	@GetMapping("/updateCountry/{id}")
	public String updateCountry(@PathVariable int id, Model model){
		Country country = countryService.findOne(id);
		model.addAttribute("updateCountry", countryService.countriesWithCities(id));
		model.addAttribute("cities", cityService.findAll());
		model.addAttribute("currentCountry", country);

		return "updateCountry";
	}
	@PostMapping("/updateCountry/{countryId}")
	public String updateCountry(@PathVariable int countryId, @RequestParam int cityId,
								@RequestParam String name, Model model) throws Exception {

		Country country = countryService.findOne(countryId);
		country.setName(name);


		try {
				countryService.update(country, cityId);

		}catch (Exception e){

			if(e.getMessage().equals(UpdateCountryValidatorMessager.EMPTY_COUNTRYNAME)){
				model.addAttribute("updateCountryNameException", e.getMessage());
			}
			model.addAttribute("currentCountry", country);
			model.addAttribute("cities", cityService.findAll());
			return "updateCountry";
		}
		return "redirect:/country";
	}
}
