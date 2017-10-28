package com.shop.controller;

import com.shop.service.CityService;
import com.shop.validator.manufacturerValidator.ManufacturerValidatorMessages;
import jdk.internal.org.objectweb.asm.tree.MultiANewArrayInsnNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.shop.entity.Country;
import com.shop.entity.Manufacturer;
import com.shop.service.CountryService;
import com.shop.service.ManufacturerService;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

@Controller
public class ManufacturerController {


	@Autowired
	private ManufacturerService manufacturerService;
	@Autowired
	private CountryService countryService;
	@Autowired
	private CityService cityService;




	@GetMapping(name = "/", value = "manufacturer")
	public String manufacturer(Model model) {
		model.addAttribute("manufacturers", manufacturerService.findAll());
		model.addAttribute("countries", countryService.findAll());
		model.addAttribute("cities", cityService.findAll());
		model.addAttribute("manufacturer", new Manufacturer());
		return "manufacturer";
	}

	@PostMapping("/manufacturer")
	public String country(@RequestParam String name, String description, @RequestParam int countryId, Model model,
						  @RequestParam("image") MultipartFile image, Manufacturer manufacturer)
			throws Exception {

		Country country = countryService.findOne(countryId);
        manufacturer.setCountry(country);

		try {
			manufacturerService.save(new Manufacturer(name, description), countryId, image);
		} catch (Exception e) {
			if (e.getMessage().equals(ManufacturerValidatorMessages.EMPTY_MANUFACTURERNAME_FIELD) ||
					e.getMessage().equals(ManufacturerValidatorMessages.MANUFACTURERNAME_EXIST)) {
				model.addAttribute("manufacturerNameExeptions", e.getMessage());
			} else if (e.getMessage().equals(ManufacturerValidatorMessages.EMPTY_MANUFACTURERDESCRIPTION_FIELD) ||
					e.getMessage().equals(ManufacturerValidatorMessages.MANUFACTURERDESCRIPTION_EXIST)) {
				model.addAttribute("manufacturerDescriptionExeptions", e.getMessage());
			}
			model.addAttribute("manufacturers", manufacturerService.findAll());
			model.addAttribute("countries", countryService.findAll());
			model.addAttribute("cities", cityService.findAll());
			return "manufacturer";
		}

		return "redirect:/manufacturer";
	}

	@GetMapping("/deleteManufacturer/{id}")
	public String deleteManufacturer(@PathVariable int id) {

		manufacturerService.delete(id);

		return "redirect:/manufacturer";
	}

	@GetMapping("/updateManufacturer/{id}")
	public String updateManufacturer(@PathVariable int id, Model model) {

		Manufacturer manufacturer = manufacturerService.findOne(id);

		model.addAttribute("countries", countryService.findAll());
		model.addAttribute("currentManufactory", manufacturer);
		model.addAttribute("uploadManufacturers", manufacturerService.findAll());


		return "updateManufacturer";
	}

	@PostMapping("/updateManufacturer/{id}")
	public String updateManufacturer(@PathVariable int id, @RequestParam int countryId,
									 @RequestParam String name, @RequestParam String description, Model model,
									 @RequestParam("image") MultipartFile image
	) throws Exception {

		Manufacturer manufacturer = manufacturerService.findOne(id);

//		if (!image.isEmpty()) {
//			try {
//				String realPathtoUploads = System.getProperty("catalina.home") + "/resources/"
//						+ manufacturer.getName() + "/" + image.getOriginalFilename();
//				if (!new File(realPathtoUploads).exists()) {
//					new File(realPathtoUploads).mkdir();
//				}
//
//
//				String orgName = image.getOriginalFilename();
//				String filePath = realPathtoUploads + orgName;
//				File dest = new File(filePath);
//				image.transferTo(dest);
//			}catch (Exception e){
//				e.getStackTrace();
//			}
//		}

				try {
					manufacturer.setName(name);
					manufacturer.setDescription(description);
					manufacturerService.update(manufacturer, countryId, image);
				} catch (Exception e) {
					if (e.getMessage().equals(ManufacturerValidatorMessages.EMPTY_MANUFACTURERNAME_FIELD)) {
						model.addAttribute("updateManufacturerNameExeptions", e.getMessage());
					} else if (e.getMessage().equals(ManufacturerValidatorMessages.EMPTY_MANUFACTURERDESCRIPTION_FIELD)) {
						model.addAttribute("updateManufacturerDescriptionExeptions", e.getMessage());
					}
					model.addAttribute("currentManufactory", manufacturer);
					model.addAttribute("countries", countryService.findAll());
					return "updateManufacturer";
				}

				return "redirect:/manufacturer";
			}
		}

