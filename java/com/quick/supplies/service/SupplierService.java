package com.quick.supplies.service;

import java.util.List;

import com.quick.supplies.domain.Supplier;

public interface SupplierService {
void addSupplier(Supplier supplier);
	
	List <Supplier> getAllSuppliers();
	
    public void updateSupplierDetails(Supplier supplier);
		
	public void deleteSupplierDetails(int supplier_Id);
	 
	public Supplier findSupplierById(int supplier_Id);
}
