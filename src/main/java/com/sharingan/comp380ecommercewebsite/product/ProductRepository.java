package com.sharingan.comp380ecommercewebsite.product;

import org.springframework.data.repository.CrudRepository;

/**
 * This class provides an object that reflects the database. In this case, it is a repository object of
 * products from our database
 *
 * @author Jim Inong
 * @since 2021-22-11
 */
public interface ProductRepository extends CrudRepository<Product, Integer> {}
