package com.shop.controller;

import com.shop.entity.SpeceficationType;
import com.shop.service.SpeceficationService;
import com.shop.service.SpeceficationTypeService;
import com.shop.validator.propertyValidator.PropertyValidatorMessages;
import com.shop.validator.speceficationTypeValidator.SpeceficationTypeValidatorMessages;
import com.shop.validator.speceficationTypeValidator.UpdateSpeceficationTypeValidatorMessages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class SpeceficationTypeController {

    @Autowired
    private SpeceficationTypeService speceficationTypeService;

    @GetMapping("/speceficationType")
    public String speceficationType(Model model) {
        model.addAttribute("speceficationTypes", speceficationTypeService.findAll());
        model.addAttribute("speceficationType", new SpeceficationType());
        return "speceficationType";
    }

    @PostMapping("/speceficationType")
    public String speceficationTypeService(@ModelAttribute SpeceficationType speceficationType, Model model) {

        try {
            speceficationTypeService.save(speceficationType);
        } catch (Exception e) {
            if (e.getMessage().equals(SpeceficationTypeValidatorMessages.EMPTY_SPECEFICATIONTYPE_FIELD)) {
                model.addAttribute("speceficationTypeEmptyNameExeptions", e.getMessage());
            } else if (e.getMessage().equals(SpeceficationTypeValidatorMessages.SPECEFICATIONTYPE_EXIST)) {
                model.addAttribute("speceficationTypeExistNameExeptions", e.getMessage());
            }
            model.addAttribute("speceficationTypes", speceficationTypeService.findAll());
            return "speceficationType";
        }

        return "redirect:/speceficationType";
    }

    @GetMapping("/deleteSpeceficationType/{id}")
    public String deleteCity(@PathVariable int id) {

        speceficationTypeService.delete(id);

        return "redirect:/speceficationType";
    }

    @GetMapping("/updateSpeceficationType/{id}")
    public String updateSpeceficationType(@PathVariable int id, Model model) {
        SpeceficationType speceficationType = speceficationTypeService.findOne(id);
        model.addAttribute("currentSpeceficationType", speceficationType);
        return "updateSpeceficationType";
    }

    @PostMapping("/updateSpeceficationType/{id}")
    public String SpeceficationType(@PathVariable int id, @RequestParam String name, Model model) throws Exception {
        SpeceficationType speceficationType = speceficationTypeService.findOne(id);

        try {
            speceficationType.setName(name);
            speceficationTypeService.update(speceficationType);
        } catch (Exception e) {
            if (e.getMessage().equals(UpdateSpeceficationTypeValidatorMessages.EMPTY_SPECEFICATIONTYPE)) {
                model.addAttribute("updateSpeceficationTypeNameExeptions", e.getMessage());
            }
            model.addAttribute("currentSpeceficationType", speceficationType);
            return "updateSpeceficationType";
            }

            return "redirect:/speceficationType";
        }

    }



