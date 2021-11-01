package com.sharingan.comp380ecommercewebsite.product;

import com.sharingan.comp380ecommercewebsite.sqltest.User;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Integer> {}
