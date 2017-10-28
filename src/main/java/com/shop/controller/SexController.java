package com.shop.controller;

import com.shop.entity.Sex;
import com.shop.service.SexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;


@Controller
public class SexController {

    @Autowired
    private SexService sexService;

    @GetMapping("/sex")
    public String sex(Model model){
     model.addAttribute("sexs", sexService.findAll());
     model.addAttribute("sex", new Sex());

     return "sex";
    }

    @PostMapping("/sex")
    public String sex(@ModelAttribute Sex sex) {
        sexService.save(sex);

        return "redirect:/sex";
    }
    @GetMapping("/deleteSex/{id}")
        public String delete(@PathVariable int id){

            sexService.delete(id);

            return "redirect:/sex";
        }

    @GetMapping("/updateSex/{id}")
    public String updateSex(@PathVariable int id, Model model){

        Sex sex = sexService.findOne(id);

        model.addAttribute("currentSex", sex );

        return "updateSex";
    }

    @PostMapping("/updateSex/{id}")
    public String updateSex(@PathVariable int id,  @RequestParam String type){

        Sex sex = sexService.findOne(id);

        sex.setType(type);

        sexService.update(sex);

        return "redirect:/sex";
    }
    }

