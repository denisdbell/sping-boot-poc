package com.advantum.barcode.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Product {
	
	   @Id
	   @Column(name="id")
	   private Integer productId;
	   @Column(name="name")
       private String productName;
	   @Column(name="code")
       private String productCode;
	   @Column(name="releasedate")
       private Date releaseDate;
	   @Column(name="description")
       private String description;
	   @Column(name="price")
       private Double price;
	   @Column(name="starrating")
       private Double starRating;
	   @Column(name="imageurl")
       private String imageUrl;

       public Product(Integer productId, String productName, String productCode, Date releaseDate, String description,
			Double price, Double starRating, String imageUrl) {
		
		this.productId = productId;
		this.productName = productName;
		this.productCode = productCode;
		this.releaseDate = releaseDate;
		this.description = description;
		this.price = price;
		this.starRating = starRating;
		this.imageUrl = imageUrl;
	}
	
       
    public Product(){
    	   
    }
       
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductCode() {
		return productCode;
	}
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}
	public Date getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
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
	public Double getStarRating() {
		return starRating;
	}
	public void setStarRating(Double starRating) {
		this.starRating = starRating;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
}
