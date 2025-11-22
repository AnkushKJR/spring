package com.practice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class loginController {
	
	@RequestMapping("/loginPage")
	public ModelAndView loginPage() {
		ModelAndView mv =  new ModelAndView();
		mv.setViewName("loginPage");
		return mv;
	}	
	
}
