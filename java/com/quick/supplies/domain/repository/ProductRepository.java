package com.quick.supplies.domain.repository;

import java.util.List;

import com.quick.supplies.domain.Product;

public interface ProductRepository {

	void addProduct(Product product);
	
	List <Product> getAllProducts();
	
	//List<Product> getProductsByCategory(String category);
	
	Product getProductById(String productID);
	
	public void updateProduct(Product product);
	
	public void updateDeliveryStatus(Product product);
	
	public void deleteProduct(int proId);
	 
	public Product findProduct(int proId);
	
}
