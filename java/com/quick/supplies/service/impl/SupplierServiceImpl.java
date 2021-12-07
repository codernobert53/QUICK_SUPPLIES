package com.quick.supplies.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quick.supplies.domain.Supplier;
import com.quick.supplies.domain.repository.SupplierRepository;
import com.quick.supplies.service.SupplierService;

@Service
public class SupplierServiceImpl implements SupplierService{

	@Autowired
	 private SupplierRepository supplierRepository;

	@Override
	public void addSupplier(Supplier supplier) {
		supplierRepository.addSupplier(supplier);
	}

	@Override
	public List<Supplier> getAllSuppliers() {
		return supplierRepository.getAllSuppliers();
	}

	@Override
	public void updateSupplierDetails(Supplier supplier) {
		supplierRepository.updateSupplierDetails(supplier);
	}

	@Override
	public void deleteSupplierDetails(int supplier_Id) {
		supplierRepository.deleteSupplierDetails(supplier_Id);
	}

	@Override
	public Supplier findSupplierById(int supplier_Id) {
		return supplierRepository.findSupplierById(supplier_Id);
	}
	
	
	
}
