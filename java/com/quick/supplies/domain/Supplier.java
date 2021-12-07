package com.quick.supplies.domain;

import java.io.Serializable;

public class Supplier implements Serializable{

	private static final long serialVersionUID = 3678107792576131001L;
	
	public Supplier() {
		super();
		// TODO Auto-generated constructor stub
	}

	private int supplier_Id;
	private String name;
	private String contact;
	private String address;
	
	
	
	public Supplier(int supplier_Id) {
		super();
		this.supplier_Id = supplier_Id;
	}

	public int getSupplier_Id() {
		return supplier_Id;
	}

	public void setSupplier_Id(int supplier_Id) {
		this.supplier_Id = supplier_Id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	
	
}
