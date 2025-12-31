package com.zepto.order.repository;

import org.springframework.data.repository.CrudRepository;

import com.zepto.order.entity.Order;

public interface OrderRepository extends CrudRepository<Order, String>{

}
