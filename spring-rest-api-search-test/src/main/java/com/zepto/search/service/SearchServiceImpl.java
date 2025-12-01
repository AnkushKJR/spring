package com.zepto.search.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zepto.search.dao.SearchDAOImpl;
import com.zepto.search.entity.Product;
import com.zepto.search.request.ProductRequest;
import com.zepto.search.response.ProductResponse;

@Service
public class SearchServiceImpl implements SearchService{
	
	@Autowired
	SearchDAOImpl searchDAOImpl;
	
	@Override
	public ProductResponse getProductByNameAndCategory(ProductRequest productRequest) {
		
		Product p = searchDAOImpl.findByNameAndCategory(productRequest);
		
		ProductResponse productResponse = new ProductResponse();
		
		productResponse.setId(p.getId());
		productResponse.setName(p.getName());
		productResponse.setDescription(p.getDescription());
		productResponse.setPrice(p.getPrice());
		productResponse.setCategory(p.getCategory());
		
		return productResponse;
		
	}

}
