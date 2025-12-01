package com.zepto.search.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.zepto.search.request.ProductCreateRequest;
import com.zepto.search.service.ProductServiceImpl;

@RestController
public class ProductController {
	
	@Autowired
	ProductServiceImpl productServiceImpl;
	
	@PostMapping("/addProduct")
	public void addProduct(@RequestBody ProductCreateRequest productCreateRequest) {
		productServiceImpl.createProduct(productCreateRequest);
	}

}
