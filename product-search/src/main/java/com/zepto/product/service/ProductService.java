package com.zepto.product.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.zepto.product.entity.Product;
import com.zepto.product.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository productRepository;
	
	@Cacheable(value = "product", key = "#name", unless = "#result == null")
	public Product getProductById(String name) {
		System.out.println("Fetching from DB...");
		return productRepository.findByName(name).orElseThrow(() -> new RuntimeException("Product not found"));	
	}

}
