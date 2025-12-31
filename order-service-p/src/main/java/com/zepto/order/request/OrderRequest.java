package com.zepto.order.request;

import java.util.ArrayList;

public class OrderRequest {
	
	private String customerId;
	private ArrayList<String> products;
	private ArrayList<Integer> prices;
	private Integer totalPrice;
	private String paymentStatus;
	
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public ArrayList<String> getProducts() {
		return products;
	}
	public void setProducts(ArrayList<String> products) {
		this.products = products;
	}
	public ArrayList<Integer> getPrices() {
		return prices;
	}
	public void setPrices(ArrayList<Integer> prices) {
		this.prices = prices;
	}
	public Integer getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(Integer totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

}
