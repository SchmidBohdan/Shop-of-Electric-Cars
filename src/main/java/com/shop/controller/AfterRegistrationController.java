package com.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by ooo on 7/11/2017.
 */
@Controller
public class AfterRegistrationController {


    @GetMapping("/afterRegistration")
    public String afterRegistration(){
        return "afterRegistration";
    }
}
