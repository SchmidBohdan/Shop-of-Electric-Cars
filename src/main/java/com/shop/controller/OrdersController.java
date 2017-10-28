package com.shop.controller;

import com.shop.dao.UserDao;
import com.shop.entity.Orders;
import com.shop.entity.User;
import com.shop.service.OrderService;
import com.shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

@Controller
public class OrdersController {

    @Autowired
    private OrderService orderService;
    @Autowired
    private UserService userService;
    @Autowired
    private UserDao userDao;

    @GetMapping("/addIntoGarage/{id}")
    public String buy(Principal principal, @PathVariable int id){

        orderService.addIntoBusket(principal, id);

        return "redirect:/";
    }

    @GetMapping("/deleteFromBasket/{userId}/{speceficationId}")
    public String deleteFromBasket(@PathVariable int userId, @PathVariable int speceficationId){

        orderService.deleteFromBasket(userId, speceficationId);

        return "redirect:/profile";
    }

    @PostMapping("/buy/{userId}")
    public String buy(@PathVariable int userId){
        orderService.buy(userId);
        return "afterBuy";
    }

}

