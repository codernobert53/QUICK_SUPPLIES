package com.quick.supplies.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quick.supplies.domain.Admin;
import com.quick.supplies.domain.OrdersMade;
import com.quick.supplies.domain.repository.AdminRepository;
import com.quick.supplies.domain.repository.OrdersMadeRepository;
import com.quick.supplies.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	 private AdminRepository adminRepository;
	
	@Autowired
	 private  OrdersMadeRepository ordersMadeRepository;
	
	@Override
	public void addPriceTrends(Admin admin) {
		adminRepository.addPriceTrends(admin);		
	}

	@Override
	public List<Admin> getAllPriceTrends() {
		return adminRepository.getAllPriceTrends();
	}

	@Override
	public void updatePriceTrends(Admin admin) {
		adminRepository.updatePriceTrends(admin);
	}

	@Override
	public void deletePriceTrends(int priceTrend_id) {
		adminRepository.deletePriceTrends(priceTrend_id);
	}

	@Override
	public Admin findPriceTrendsById(int priceTrend_id) {
		return adminRepository.findPriceTrendsById(priceTrend_id);
	}

	@Override
	public void addOrder(Admin admin) {
		adminRepository.addOrder(admin);
	}

	@Override
	public List<OrdersMade> getAllOrdersMade() {
		return ordersMadeRepository.getAllOrdersMade();
	}

	@Override
	public OrdersMade findOrdersById(int orderId) {
		return ordersMadeRepository.findOrdersById(orderId);
	}

	@Override
	public void deleteOrder(int orderId) {
		ordersMadeRepository.deleteOrder(orderId);
	}

	@Override
	public List<OrdersMade> getAllDeliveredOrders() {
		return ordersMadeRepository.getAllDeliveredOrders();
	}

	@Override
	public OrdersMade getOrderById(String productId) {
		return ordersMadeRepository.getOrderById(productId);
	}

	@Override
	public List<OrdersMade> countAllOrders() {
		return ordersMadeRepository.countAllOrders();
	}
	
}
