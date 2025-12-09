package com.zepto.order.request;

import java.util.List;

public class OrderRequest {
	
	private List<String> productList;
	private String[] priceList;
	private String status;
	
	public List<String> getProductList() {
		return productList;
	}
	public void setProductList(List<String> productList) {
		this.productList = productList;
	}
	public String[] getPriceList() {
		return priceList;
	}
	public void setPriceList(String[] priceList) {
		this.priceList = priceList;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
