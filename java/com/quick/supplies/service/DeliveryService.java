package com.quick.supplies.service;

import java.util.List;

import com.quick.supplies.domain.Delivery;

public interface DeliveryService {

	public List<Delivery> findOrderById(int orderId);

	public int update(Delivery student);
	
	public List<Delivery> read();
	
}
