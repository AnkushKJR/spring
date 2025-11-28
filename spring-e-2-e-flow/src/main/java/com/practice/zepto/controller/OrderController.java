package com.practice.zepto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.practice.zepto.bean.OrderInfo;
import com.practice.zepto.service.OrderService;

@Controller
public class OrderController {
	
	@Autowired
	OrderService orderService;
	
	@RequestMapping("/orderPage")
	public String showOrderPage() {
		return "order";
	}
	
	@PostMapping("/placeOrder")
	public String placeOrder(@ModelAttribute OrderInfo orderInfo, Model model) {
		System.out.println(orderInfo.getItem());
		int orderId = orderService.createOrder(orderInfo);
		model.addAttribute("orderId", orderId);
		return "order-success";
	}
	
}
