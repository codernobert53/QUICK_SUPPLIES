package com.quick.supplies.service;

import java.util.List;

import com.quick.supplies.domain.Product;


public interface ProductService {

    void addProduct(Product product);
	
	List <Product> getAllProducts();
	
	// void updateAllStock();
	
	//List<Product> getProductsByCategory(String category);
	
	Product getProductById(String productID);
	
	public void updateProduct(Product product);

	public void deleteProduct(int proId);
	 
	public Product findProduct(int proId);
	
	public void updateDeliveryStatus(Product product);

	
}
