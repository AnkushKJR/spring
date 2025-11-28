package com.practice.zepto.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.zepto.bean.OrderInfo;
import com.practice.zepto.dao.OrderDAO;
import com.practice.zepto.entity.Order;

@Service
public class OrderService {
	
	@Autowired
	OrderDAO orderDAO;
	
	public int createOrder(OrderInfo orderInfo) {
		
		Order orderEntity = new Order();
		
		orderEntity.setItem(orderInfo.getItem());
		orderEntity.setQty(orderInfo.getQty());
		orderEntity.setPrice(orderInfo.getPrice());
		orderEntity.setAddress(orderInfo.getAddress());
		
		int orderId = orderDAO.saveOrder(orderEntity);
		
		return orderId;
	}

}
