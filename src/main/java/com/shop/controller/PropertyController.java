package com.shop.controller;

import com.shop.entity.Property;
import com.shop.service.PropertyService;
import com.shop.validator.propertyValidator.PropertyValidatorMessages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PropertyController {

    @Autowired
    private PropertyService propertyServise;

    @GetMapping("/property")
    public String property(Model model){
        model.addAttribute("properties", propertyServise.findAll());
        return "property";
    }
    @PostMapping("/property")
    public String property(@RequestParam String name, Model model) throws Exception{
        try {
            propertyServise.save(new Property(name));
        }catch (Exception e) {
            if (e.getMessage().equals(PropertyValidatorMessages.EMPTY_PROPERTY_FIELD)) {
                model.addAttribute("propertyEmptyNameExeptions", e.getMessage());
            }else if(e.getMessage().equals(PropertyValidatorMessages.PROPERTY_ALREADY_EXIST)) {
                model.addAttribute("propertyExistNameExeptions", e.getMessage());
            }
            return "property";
        }

        return "redirect:/property";
    }
    @GetMapping("/deleteProperty/{id}")
    public String delete(@PathVariable int id){
        propertyServise.delete(id);
        return "redirect:/property";
    }
    @GetMapping("/updateProperty/{id}")
    public String updateProperty(@PathVariable int id, Model model){
        Property property = propertyServise.findOne(id);
        model.addAttribute("currentProperty", property);
        return "updateProperty";
    }
    @PostMapping("/updateProperty/{id}")
    public String update(@PathVariable int id, @RequestParam String name, Model model) throws Exception{
        Property property = propertyServise.findOne(id);
        try {
            property.setName(name);
            propertyServise.update(property);
        }catch (Exception e) {
            if (e.getMessage().equals(PropertyValidatorMessages.EMPTY_PROPERTY_FIELD)) {
                model.addAttribute("updatePropertyEmptyNameExeptions", e.getMessage());
            }
            model.addAttribute("currentProperty", property);
            return "updateProperty";
        }
        return "redirect:/property";
    }
}
