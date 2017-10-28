package com.shop.controller;

import com.shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

/**
 * Created by ooo on 7/1/2017.
 */
@Controller
public class GarageController {

    @Autowired
    private UserService userService;

    @GetMapping("/profile")
    public String profile(Principal principal, Model model){

        model.addAttribute("userBasket", userService.findUserWithSpecefication(Integer.parseInt(principal.getName())));

        return "profile";
    }
}
