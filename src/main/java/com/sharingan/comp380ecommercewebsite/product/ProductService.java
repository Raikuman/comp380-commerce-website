package com.sharingan.comp380ecommercewebsite.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	public List<Product> findAll() {
		return (List<Product>) productRepository.findAll();
	}

	public Product findById(int id) {
		return productRepository.findById(id).orElseThrow(RuntimeException::new);
	}
}
