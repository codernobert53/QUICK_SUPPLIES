package com.quick.supplies.domain;

import java.io.Serializable;

public class Admin implements Serializable{

	private static final long serialVersionUID = 3678107792576131001L;
	
	 private int priceTrend_id;
	 
     private String product;
	 private String location;
	 private String quantity;
	 private String low;
	 private String high;
	 private String date;
	 
	 private String productId;
	 private String delivery_status;
	 private String owner;
	 private String contact;
	 private String weight;
	 private String unitPrice;
	 private String description;

	

	public Admin(int priceTrend_id) {
		super();
		this.priceTrend_id = priceTrend_id;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(String unitPrice) {
		this.unitPrice = unitPrice;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	


	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getPriceTrend_id() {
		return priceTrend_id;
	}

	public void setPriceTrend_id(int priceTrend_id) {
		this.priceTrend_id = priceTrend_id;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getLow() {
		return low;
	}

	public void setLow(String low) {
		this.low = low;
	}

	public String getHigh() {
		return high;
	}

	public void setHigh(String high) {
		this.high = high;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getDelivery_status() {
		return delivery_status;
	}

	public void setDelivery_status(String delivery_status) {
		this.delivery_status = delivery_status;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

}
