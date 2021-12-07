package com.quick.supplies.domain.repository;

import java.util.List;

import com.quick.supplies.domain.OrdersMade;

public interface OrdersMadeRepository {

	List <OrdersMade> getAllOrdersMade();
	
	List <OrdersMade> getAllDeliveredOrders();
	
	List <OrdersMade> countAllOrders();
	
    public OrdersMade findOrdersById(int orderId);

//	public OrdersMade findOrdersId(int orderId);
    public void deleteOrder(int orderId);
    
    OrdersMade getOrderById(String productId);
}
