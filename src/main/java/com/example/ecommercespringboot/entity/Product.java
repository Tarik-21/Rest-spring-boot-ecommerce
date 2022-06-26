package com.example.ecommercespringboot.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
public class Product{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	@Column(name="id_product")
	private int id;
	
	@Column(name="title")
	private String title;
	
	@Column(name="short_description")
	private String shortDescription;
	
	@Column(name="description")
	private String description;
	
	@Column(name="price")
	private Double price;
	
	@Column(name = "imageUrl")
	private String imageUrl;
	
	

	@ManyToOne
	@JoinColumn(name = "id_category")
	private Category category;
	
	public Product() {}
	

	public Product(String title, String shortDescription, String description, Double price, Category category) {
		super();
		this.title = title;
		this.shortDescription = shortDescription;
		this.description = description;
		this.price = price;
		this.category = category;
	}




	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
	
	

	public String getImageUrl() {
		return imageUrl;
	}


	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}


	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	
	
}
