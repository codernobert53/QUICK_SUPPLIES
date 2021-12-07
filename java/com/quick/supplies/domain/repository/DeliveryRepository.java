package com.quick.supplies.domain.repository;

import java.util.List;

import com.quick.supplies.domain.Delivery;

public interface DeliveryRepository {
	public List<Delivery> findOrderById(int orderId);

	public int update(Delivery delivery);
	
	public List<Delivery> read();
}
