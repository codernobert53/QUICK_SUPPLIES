package com.quick.supplies.domain.repository;

import java.util.List;

import com.quick.supplies.domain.Admin;

public interface AdminRepository {
    
	void addPriceTrends(Admin admin);
	
	void addOrder(Admin admin);
	
	List <Admin> getAllPriceTrends();
			
    public void updatePriceTrends(Admin admin);
	
    
	public void deletePriceTrends(int priceTrend_id);
	 
	public Admin findPriceTrendsById(int priceTrend_id);
	
}
