package com.shop.controller;

import com.shop.dao.UserDao;
import com.shop.entity.User;
import com.shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Created by ooo on 7/11/2017.
 */
@Controller
public class AfterBuy {

    @Autowired
    private UserService userService;

    @GetMapping("/afterBuy")
    public String afterBuy(@PathVariable int id,  Model model){
        model.addAttribute("currentUser", userService.findOne(id));
        return "afterBuy";
    }
}
