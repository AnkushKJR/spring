package com.zepto.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zepto.product.entity.Product;
import com.zepto.product.service.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@GetMapping("/search")
	public Product search(@RequestParam String name) {
		System.out.println("ProductController.search() sending start time to APM and action name");
		System.out.println("ProductController.search()..........................................");
		System.out.println("ProductController.search() sending end time to APM and action name");
		return productService.getProductById(name);
		
	}

}
