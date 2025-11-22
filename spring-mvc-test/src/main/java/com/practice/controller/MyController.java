package com.practice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {
	@RequestMapping("/myPage")
	public ModelAndView viewPage() {
		System.out.println("MyController.viewPage()");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("hello");
		return mv;
	}
}
