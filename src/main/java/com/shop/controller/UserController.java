package com.shop.controller;


import com.shop.entity.Sex;
import com.shop.service.MailSenderService;
import com.shop.service.SexService;
import com.shop.validator.Validator;
import com.shop.validator.userLoginValidation.UserLoginValidationMessages;
import com.shop.validator.userValidator.UserValidator;
import com.shop.validator.userValidator.UserValidatorMessages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.shop.entity.User;
import com.shop.service.UserService;

import javax.mail.internet.MimeMessage;
import java.security.Principal;
import java.util.UUID;

@Controller
	public class UserController {

	@Autowired
	private UserService	userService;
	@Autowired
	private SexService sexService;
	@Autowired
	private MailSenderService mailSenderService;
	@Qualifier("userLoginValidator")
	private Validator validator;


	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String signup(Model model) {
		model.addAttribute("sex", sexService.findAll());
		return "signup";
	}

	@RequestMapping(value = "/saveUser", method = RequestMethod.POST)
	public String saveUser(@RequestParam String userfirstName, @RequestParam String userlastName,
						   @RequestParam String useremail,
						   @RequestParam String userpassword, @RequestParam String usernumberPhone,
						   @RequestParam String useraddress, @RequestParam int sexId, Model model) {

		Sex sex =  sexService.findOne(sexId);
		User user = new User();

		String uuid = UUID.randomUUID().toString();

		user.setFirstName(userfirstName);
		user.setLastName(userlastName);
		user.setEmail(useremail);
		user.setPassword(userpassword);
		user.setAddress(useraddress);
		user.setNumberPhone(usernumberPhone);
		user.setSex(sex);

		user.setUuid(uuid);

		try {

				userService.save(user, sexId);

		} catch (Exception e) {
			if(e.getMessage().equals(UserValidatorMessages.EMPTY_USER_FIRSTNAME_FIELD) ||
					e.getMessage().equals(UserValidatorMessages.USER_FIRSTNAME_ALREADY_EXIST )){
				 model.addAttribute("userFirstNameExeptions", e.getMessage());
			} if(e.getMessage().equals(UserValidatorMessages.EMPTY_USER_LASTNAME_FIELD) ||
					e.getMessage().equals(UserValidatorMessages.USER_LASTTNAME_ALREADY_EXIST)){
				model.addAttribute("userLastNameExeption", e.getMessage());
			} if(e.getMessage().equals(UserValidatorMessages.EMPTY_PASSWORD) ||
					e.getMessage().equals(UserValidatorMessages.PASSWORD_IS_SHORT)){
				model.addAttribute("userPasswordExeption", e.getMessage());
			} if(e.getMessage().equals(UserValidatorMessages.EMPTY_EMAIL) ||
					e.getMessage().equals(UserValidatorMessages.EMAIL_ALREADY_EXIST)){
				model.addAttribute("userEmailExeption", e.getMessage());
			} if(e.getMessage().equals(UserValidatorMessages.EMPTY_NUMBERPHONE) ||
					e.getMessage().equals(UserValidatorMessages.NUMBERFHONE_ALREADY_EXIST) ||
					e.getMessage().equals(UserValidatorMessages.NUMBERPHONE_IS_SHORT) ||
					e.getMessage().equals(UserValidatorMessages.IT_IS_NOT_BE_WORD)){
				model.addAttribute("userNumberPhoneExeption", e.getMessage());
			} if(e.getMessage().equals(UserValidatorMessages.EMPTY_ADRESS)){
				model.addAttribute("userAdressExeption", e.getMessage());
			}
			return "signup";
		}


		String theme = "Thank's for registration";
		String mailBody = "Confirm Registration     http://localhost:8080/confirm/" + uuid;

		mailSenderService.sendMail(theme, mailBody, user.getEmail());

		return "redirect:/afterRegistration";

	}


	@GetMapping("/confirm/{uuid}")
	public String confirm(@PathVariable String uuid) {

		User user = userService.findByUuid(uuid);
		user.setEnable(true);

		userService.update(user);

		return "redirect:/";
	}
	

	@RequestMapping(value="/deleteUser/{id}", method=RequestMethod.GET)
		public String deleteUser(@PathVariable int id){

			userService.delete(id);

		return "redirect:/signup";

	}
}
