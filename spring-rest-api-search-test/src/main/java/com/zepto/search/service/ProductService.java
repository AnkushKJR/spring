package com.zepto.search.service;

import com.zepto.search.request.ProductCreateRequest;

public interface ProductService {
	
	public abstract void createProduct(ProductCreateRequest productCreateRequest);
	
}
