package com.zepto.search.dao;

import com.zepto.search.entity.Product;
import com.zepto.search.request.ProductRequest;

public interface SearchDAO {
	
	public abstract Product findByNameAndCategory(ProductRequest productRequest);

}
