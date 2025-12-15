package com.zepto.order.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.zepto.order.entity.Order;

@Repository
public interface OrderRepository extends CrudRepository<Order, Integer>{
	
	Optional<Order> findById(int orderId);

}
