package com.shop.controller;


import com.shop.entity.Product;
import com.shop.entity.Property;
import com.shop.entity.Specefication;
import com.shop.entity.SpeceficationType;
import com.shop.service.ProductService;
import com.shop.service.PropertyService;
import com.shop.service.SpeceficationService;
import com.shop.service.SpeceficationTypeService;
import com.shop.validator.speceficationValidator.SpeceficationValidatorMessages;
import com.shop.validator.speceficationValidator.UpdateSpeceficationValidatorMessages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;


@Controller
public class SpeceficationController {

    @Autowired
    private SpeceficationService speceficationService;
    @Autowired
    private ProductService productService;
    @Autowired
    private PropertyService propertyService;
    @Autowired
    private SpeceficationTypeService speceficationTypeService;

    @GetMapping("/specefication")
    public String specefication(Model model, @PageableDefault Pageable pageable){
        model.addAttribute("products", productService.findAll());
        model.addAttribute("specefications", speceficationService.findAllPages(pageable));
        model.addAttribute("speceficationss", speceficationService.findAll());
        model.addAttribute("properties",  propertyService.findAll());
        model.addAttribute("speceficationTypes", speceficationTypeService.findAll());
        model.addAttribute("specefication", new Specefication());
        return "specefication";
    }
    @PostMapping("/specefication")
    public String specefication(@ModelAttribute Specefication specefication,
                                @RequestParam int productId,
                                @RequestParam int propertyId,
                                @RequestParam int speceficationTypeId,
                                Model model, @RequestParam("image") MultipartFile image, @PageableDefault Pageable pageable)throws Exception{

        Product product = productService.findOne(productId);
        SpeceficationType speceficationType = speceficationTypeService.findOne(speceficationTypeId);
        Property property = propertyService.findOne(propertyId);

        specefication.setSpeceficationType(speceficationType);
        specefication.setProduct(product);
        specefication.setProperty(property);


        try {

            speceficationService.save(specefication, productId, propertyId, speceficationTypeId, image);

        }catch (Exception e) {

            if(e.getMessage().equals(SpeceficationValidatorMessages.EMPTY_SPECEFICATION_DESCRIPTION_FIELD) ||
                    e.getMessage().equals(SpeceficationValidatorMessages.SPECEFICATION_DESCRIPTION_EXIST)) {
                model.addAttribute("speceficationDescriptionExeptions", e.getMessage());
            }
            model.addAttribute("specefications", speceficationService.findAll());
            model.addAttribute("properties",  propertyService.findAll());
            model.addAttribute("speceficationTypes", speceficationTypeService.findAll());
            model.addAttribute("products", productService.findAll());
            model.addAttribute("specefications", speceficationService.findAllPages(pageable));
            return "specefication";
        }
        return "redirect:/specefication";
    }
    @GetMapping("/deleteSpecefication/{id}")
    public String delete(@PathVariable int id){
        speceficationService.delete(id);
        return "redirect:/specefication";
    }
    @GetMapping("/updateSpecefication/{id}")
    public String updateProperty(@PathVariable int id, Model model){
        Specefication specefication =  speceficationService.findOne(id);
        model.addAttribute("speceficationTypes", speceficationTypeService.findAll());
        model.addAttribute("properties", propertyService.findAll());
        model.addAttribute("products", productService.findAll());
        model.addAttribute("currentSpecefication", specefication);
        model.addAttribute("currentProduct", speceficationService.speceficationsWithproduct(id));
        return "updateSpecefication";
    }
    @PostMapping("/updateSpecefication/{id}")
    public String updateProperty(@PathVariable int id, @RequestParam String description,
                         @RequestParam int productId, @RequestParam int propertyId,
                         @RequestParam int speceficationTypeId,
                                 Model model, @RequestParam("image") MultipartFile image) throws Exception {

        Specefication specefication = speceficationService.findOne(id);

        if(image.isEmpty()){
            speceficationService.update(specefication, productId, propertyId, speceficationTypeId, image);
        }else{
            model.addAttribute("currentSpecefication", specefication);
        }

        try {
//            specefication.setPathImage();
            specefication.setDescription(description);
            speceficationService.update(specefication, productId, propertyId, speceficationTypeId, image);

        }catch (Exception e) {
            if (e.getMessage().equals(UpdateSpeceficationValidatorMessages.EMPTY_SPECEFICATION_DESCRIPTION)) {
                model.addAttribute("updateSpeceficationDescriptionExeptions", e.getMessage());
            }
            model.addAttribute("currentSpecefication", specefication);
            model.addAttribute("speceficationTypes", speceficationTypeService.findAll());
            model.addAttribute("properties", propertyService.findAll());
            model.addAttribute("products", productService.findAll());
            return "updateSpecefication";
        }
        return "redirect:/specefication";
    }
}
