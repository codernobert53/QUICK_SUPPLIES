package com.quick.supplies.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quick.supplies.domain.Product;
import com.quick.supplies.domain.repository.ProductRepository;
import com.quick.supplies.service.ProductService;



@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	 private ProductRepository productRepository;

	@Override
	public void addProduct(Product product) {
		 productRepository.addProduct(product);
	}

	@Override
	public List<Product> getAllProducts() {
		return productRepository.getAllProducts();
	}
	
	// @Override
	 // public void updateAllStock() {
	 // List<Product> allProducts = productRepository.getAllProducts();
	// for(Product product : allProducts) {
	   //  if(product.getUnitsInStock()<500)
	    //	 productRepository.updateStock
	      //    (product.getProductId(), 
	         //   product.getUnitsInStock()+1000);
	// }
	// }

	//@Override
	//public List<Product> getProductsByCategory(String category) {
		//return productRepository.getProductsByCategory(category);
	//}

	@Override
	public Product getProductById(String productID) {
		return productRepository.getProductById(productID);
	}

	@Override
	public void updateProduct(Product product) {
		productRepository.updateProduct(product);
		
	}

	@Override
	public void deleteProduct(int proId) {
		productRepository.deleteProduct(proId);
		
	}

	@Override
	public Product findProduct(int proId) {
		return productRepository.findProduct(proId);
	}

	@Override
	public void updateDeliveryStatus(Product product) {
		productRepository.updateDeliveryStatus(product);
	}
	
}
