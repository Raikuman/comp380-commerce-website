package com.sharingan.comp380ecommercewebsite.cart;

import org.springframework.data.repository.CrudRepository;

/**
 *
 * @extends CartRepository to CrudRespository
 * @author Michael Sanati
 * @since 2021-15-11
 */

public interface CartRepository extends CrudRepository<Cart, Integer> { }
