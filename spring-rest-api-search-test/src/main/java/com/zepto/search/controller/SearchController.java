package com.zepto.search.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.zepto.search.request.ProductRequest;
import com.zepto.search.response.ProductResponse;
import com.zepto.search.service.SearchServiceImpl;

@RestController
public class SearchController {
	
//	@PostMapping("/searchProduct")
//	public ResponseEntity searchProduct(@RequestBody ProductRequest productRequest) {
//		
//		Product product = new Product();
//		
//		product.setId(1L);
//		product.setName(productRequest.getName());
//		product.setDescription("bathing soap bar");
//		product.setPrice(89d);
//		product.setCategory(productRequest.getCategory());
//		
//		return ResponseEntity.ok(product);
//		
//	}
	
	@Autowired
	SearchServiceImpl searchServiceImpl;
	
	@PostMapping("/searchProduct")
	public ResponseEntity searchProduct(@RequestBody ProductRequest productRequest) {
		
		ProductResponse productResponse = searchServiceImpl.getProductByNameAndCategory(productRequest);
		
		return ResponseEntity.ok(productResponse);
	}
	
}
