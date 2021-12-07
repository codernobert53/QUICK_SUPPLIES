package com.quick.supplies.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.quick.supplies.domain.User;
import com.quick.supplies.service.LoginService;
import com.quick.supplies.service.ProductService;

@Controller
public class UserLoginController {

	@Autowired
	 private ProductService productService;
	
	@Autowired
	private LoginService loginService;


	//LOGIN OPERATIONS
	@RequestMapping("/customerLogin")
	public String log(Model model) {
		model.addAttribute("customerLogin",productService.getAllProducts());
	    return "customerLogin";
	}
	
	@RequestMapping(value = "/customerLogin", method = RequestMethod.POST)
	public ModelAndView customer12Login(@RequestParam("email") String email, @RequestParam("password") String password) {

		ModelAndView mv = new ModelAndView();

		User user = new User();
		user.setEmail(email);
		user.setPassword(password);

		String name = loginService.loginUser(user);

		if (name != null) {
			mv.setViewName("/SupplierDashboard");

		} else {

			mv.addObject("msg", "Invalid user id or password.");
			mv.setViewName("customerLogin");
		}

		return mv;

	}


	
}
