package com.zepto.product.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.zepto.product.entity.Product;

public interface ProductRepository extends CrudRepository<Product, Integer>{
	Optional<Product> findByName(String name);
}
