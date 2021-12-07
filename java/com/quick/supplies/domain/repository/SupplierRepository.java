package com.quick.supplies.domain.repository;

import java.util.List;

import com.quick.supplies.domain.Supplier;

public interface SupplierRepository {

	void addSupplier(Supplier supplier);
	
	List <Supplier> getAllSuppliers();
	
    public void updateSupplierDetails(Supplier supplier);
		
	public void deleteSupplierDetails(int supplier_Id);
	 
	public Supplier findSupplierById(int supplier_Id);
	
}
