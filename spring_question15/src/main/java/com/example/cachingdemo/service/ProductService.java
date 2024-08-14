package com.example.cachingdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.example.cachingdemo.model.Product;
import com.example.cachingdemo.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Cacheable("products")
	public List<Product> getAllProducts() {
		System.out.println("Fetching from database...");
		return productRepository.findAll();
	}
}
