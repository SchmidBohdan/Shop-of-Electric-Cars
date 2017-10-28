package com.shop.controller;

import com.shop.entity.Guarantee;
import com.shop.entity.Manufacturer;
import com.shop.service.GuaranteeService;
import com.shop.validator.guaranteeValidator.GuaranteeValidatorMessages;
import com.shop.validator.manufacturerValidator.ManufacturerValidatorMessages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

/**
 * Created by ooo on 25.05.2017.
 */
@Controller
public class GuaranteeController {

    @Autowired
    private GuaranteeService guaranteeService;



    @GetMapping("/guarantee")
    public String guarantee(Model model){
        model.addAttribute("guaranties", guaranteeService.findAll());
        return "guarantee";
    }

    @PostMapping("/guarantee")
    public String save(@RequestParam String guaranteeTime, Model model) throws Exception{

        Guarantee guarantee = new Guarantee();
        guarantee.setStartTime(LocalDate.now());
        guarantee.setGuaranteeTime(guaranteeTime);
//        guarantee.setEndTime(guarantee.getStartTime().plusMonths(Integer.parseInt(guaranteeTime)));



        try {
            if(guaranteeTime.matches("[0-9]*") == true && guaranteeTime.isEmpty()==false){
                Integer in = Integer.parseInt(guaranteeTime);
                guarantee.setEndTime(guarantee.getStartTime().plusMonths(in));
            }
            guaranteeService.save(guarantee);
        }catch (Exception e) {
            if (e.getMessage().equals(GuaranteeValidatorMessages.EMPTY_GUARANTEETIME_FIELD) ||
                    e.getMessage().equals(GuaranteeValidatorMessages.GUARANTEETIME_EXIST) ||
                    e.getMessage().equals(GuaranteeValidatorMessages.GUARANTEETIME_NOTWORDONLYNUMBER)) {
                model.addAttribute("guaranteeNameExceptions", e.getMessage());
            }
            model.addAttribute("guaranties", guaranteeService.findAll());
            return "guarantee";
        }

        return "redirect:/guarantee";
    }

    @GetMapping("/deleteGuarantee/{id}")
    public String delete(@PathVariable int id) {
        guaranteeService.delete(id);
        return "redirect:/guarantee";
    }

    @GetMapping("/updateGuarantee/{id}")
    public String updateGuarantee(@PathVariable int id, Model model){
        Guarantee guarantee = guaranteeService.findOne(id);
        model.addAttribute("currentGuarantee", guarantee);
        return "updateGuarantee";
    }

    @PostMapping("/updateGuarantee/{id}")
    public String update(@PathVariable int id, @RequestParam String guaranteeTime, Model model) throws Exception{
        Guarantee guarantee = guaranteeService.findOne(id);
        guarantee.setGuaranteeTime(guaranteeTime);

        try {
            if(guaranteeTime.matches("[0-9]*") == true && guaranteeTime.isEmpty()==false){
                Integer in = Integer.parseInt(guaranteeTime);
                guarantee.setEndTime(guarantee.getStartTime().plusMonths(in));
            }
            guaranteeService.update(guarantee);
        }catch (Exception e) {

            if (e.getMessage().equals(GuaranteeValidatorMessages.EMPTY_GUARANTEETIME_FIELD) ||
                    e.getMessage().equals(GuaranteeValidatorMessages.GUARANTEETIME_NOTWORDONLYNUMBER)) {
                model.addAttribute("updateGuaranteeNameExceptions", e.getMessage());
            }
            model.addAttribute("currentGuarantee", guarantee);
            model.addAttribute("guaranties", guaranteeService.findAll());
            return "updateGuarantee";
        }
        return "redirect:/guarantee";
    }
}
