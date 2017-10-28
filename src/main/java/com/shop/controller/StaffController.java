package com.shop.controller;

import com.shop.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StaffController {

    @Autowired
    private StaffService staffService;

    @GetMapping("/staff")
     public String staff(Model model){
        model.addAttribute("staffs", staffService.findAll());
        return "staff";
    }

    @PostMapping("/staff")
    public String staff(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String surName,
                        @RequestParam  String email, @RequestParam String address, @RequestParam int age,
                        @RequestParam int phone ){
         return "redirect:/staff";
    }
}
