package com.zepto.search.service;

import com.zepto.search.request.ProductRequest;
import com.zepto.search.response.ProductResponse;

public interface SearchService {
	public abstract ProductResponse getProductByNameAndCategory(ProductRequest productRequest);
}
