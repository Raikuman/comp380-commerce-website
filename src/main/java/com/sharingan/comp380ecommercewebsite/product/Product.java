package com.sharingan.comp380ecommercewebsite.product;

import javax.persistence.*;

/**
 * This class provides an entity product object for spring to populate ProductRepository.java
 *
 * @author Jim Inong
 * @since 2021-22-11
 * @version 1.0
 */
@Entity
public class Product {

	/**
	 * Provides the id of the product from the database
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(
		name = "productid"
	)
	private int id;

	/**
	 * Provides the name of the product from the database
	 */
	@Column(
		name = "name"
	)
	private String name;

	/**
	 * Provides the price of the product from the database
	 */
	@Column(
		name = "price"
	)
	private double price;

	/**
	 * Provides the imageUrl of the product from the database
	 */
	@Column(
		name = "imageurl"
	)
	private String imageUrl;

	/**
	 * Empty constructor in the case of getting incorrect information from the database
	 */
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

	/**
	 * Getter for productId
	 * @return Returns id
	 */
	public int getProductId() {
		return id;
	}

	/**
	 * Getter for name
	 * @return Returns name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Getter for price
	 * @return Returns price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * Getter for imageUrl
	 * @return Returns imageUrl
	 */
	public String getImageUrl() {
		return imageUrl;
	}
}
