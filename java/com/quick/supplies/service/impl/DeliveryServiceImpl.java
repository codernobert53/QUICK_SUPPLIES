package com.quick.supplies.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quick.supplies.domain.Delivery;
import com.quick.supplies.domain.repository.DeliveryRepository;
import com.quick.supplies.service.DeliveryService;

@Service
public class DeliveryServiceImpl implements DeliveryService{

	@Autowired
	 private DeliveryRepository deliveryRepository;

	@Override
	public List<Delivery> findOrderById(int orderId) {
		return deliveryRepository.findOrderById(orderId);
	}

	@Override
	public int update(Delivery delivery) {
		return deliveryRepository.update(delivery);
	}

	@Override
	public List<Delivery> read() {
		return deliveryRepository.read();
	}
	
}
