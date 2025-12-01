package com.zepto.search.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zepto.search.dao.ProductDAOImpl;
import com.zepto.search.entity.Product;
import com.zepto.search.request.ProductCreateRequest;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	ProductDAOImpl productDAOImpl;
	
	@Override
	public void createProduct(ProductCreateRequest productCreateRequest) {
		
		Product product = new Product();
		
		product.setId(productCreateRequest.getId());
		product.setName(productCreateRequest.getName());
		product.setDescription(productCreateRequest.getDescription());
		product.setPrice(productCreateRequest.getPrice());
		product.setCategory(productCreateRequest.getCategory());
		
		productDAOImpl.saveProduct(product);
		
	}

	
}
