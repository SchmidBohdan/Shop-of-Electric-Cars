package com.shop.controller;

import com.shop.entity.User;
import com.shop.service.UserService;
import com.shop.validator.Validator;
import com.shop.validator.userLoginValidation.UserLoginValidationMessages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by ooo on 6/17/2017.
 */
@Controller
public class UserLoginController {

    @Autowired
    private UserService userService;

    @Autowired
    @Qualifier("userLoginValidation")
    private Validator validator;


    @GetMapping("/logIn")
    public String logIn(Model model){
        return "logIn";
    }

    @RequestMapping("/logIn")
    public String logIn(){
        return "redirect:/logIn";
    }

    @GetMapping("/home")
    public String home(){
        return "home";
    }

    @PostMapping("/failureLogin")
    public String failureLogin(Model model, @RequestParam String username, @RequestParam String password){

        try {
            validator.validate(new User(username, password));
        } catch (Exception e) {
            if(e.getMessage().equals(UserLoginValidationMessages.EMPTY_USERNAME_FIELD) ||
                    e.getMessage().equals(UserLoginValidationMessages.EMPTY_PASSWORD_FIELD) ||
                    e.getMessage().equals(UserLoginValidationMessages.EMPTY_USERNAME_AND_PASSWORD) ||
                    e.getMessage().equals(UserLoginValidationMessages.WRONG_USERNAME_OR_PASSWORD)) {
                model.addAttribute("userLoginExeption", e.getMessage());
            }
            return "logIn";
        }
        model.addAttribute("user", new User());

        return "redirect:/";
    }
}
