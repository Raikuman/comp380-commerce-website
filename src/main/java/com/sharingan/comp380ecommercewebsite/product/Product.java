package com.sharingan.comp380ecommercewebsite.product;

import javax.persistence.*;

/**
 * This class provides an entity product object for spring to populate ProductRepository.java
 *
 * @author Jim Inong
 * @since 2021-22-11
 */
@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(
		name = "productid"
	)
	private int id;

	@Column(
		name = "name"
	)
	private String name;

	@Column(
		name = "price"
	)
	private double price;

	@Column(
		name = "imageurl"
	)
	private String imageUrl;

	public Product(){}

	/**
	 * Constructor to populate repository with data from the database
	 * @param name Provides the name of the product
	 * @param price Provides the price of the product
	 * @param imageUrl Provides the iamgeUrl of the product
	 */
	public Product(String name, double price, String imageUrl) {
		this.name = name;
		this.price = price;
		this.imageUrl = imageUrl;
	}

	public int getProductId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	public String getImageUrl() {
		return imageUrl;
	}
}
