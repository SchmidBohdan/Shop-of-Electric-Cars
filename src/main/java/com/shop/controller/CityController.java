package com.shop.controller;

import com.shop.validator.cityValidator.CityValidatorMessages;
import com.shop.validator.cityValidator.UpdateCityValidatorMessages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.shop.entity.City;
import com.shop.service.CityService;

@Controller
public class CityController {
	@Autowired
	private CityService cityService;

	@GetMapping("/city")
	public String country(Model model) {
		model.addAttribute("cities", cityService.findAll());
		return "city";
	}

	@PostMapping("/city")
	public String city(@RequestParam String name, Model model) throws Exception {

		try {
			cityService.save(new City(name));
		}catch (Exception e) {
			if (e.getMessage().equals(CityValidatorMessages.EMPTY_CITYNAME_FIELD)) {
				model.addAttribute("cityEmptyNameExeptions", e.getMessage());
			}else if(e.getMessage().equals(CityValidatorMessages.CITYNAME_EXIST)) {
				model.addAttribute("cityExistNameExeptions", e.getMessage());
			}
			model.addAttribute("cities", cityService.findAll());
			return "city";
		}
		return "redirect:/city";
	}

	@GetMapping("/deleteCity/{id}")
	public String deleteCity(@PathVariable int id) {

		cityService.delete(id);

		return "redirect:/city";
	}

	@GetMapping("/updateCity/{id}")
public String updateCity(@PathVariable int id, Model model) {

	City city = cityService.findOne(id);

	model.addAttribute("currentCity", city);

	return "updateCity";
}

	@PostMapping("updateCity/{id}")
	public String update(@PathVariable int id, @RequestParam String name, Model model) throws Exception {

		City city = cityService.findOne(id);
		city.setName(name);

		try {

			cityService.update(city);

		}catch (Exception e) {
			if (e.getMessage().equals(UpdateCityValidatorMessages.EMPTY_CITYNAME)){
				model.addAttribute("updateCityNameExeptions", e.getMessage());
			}
			model.addAttribute("currentCity", city);
			return "updateCity";
		}

		return "redirect:/city";
	}
}


