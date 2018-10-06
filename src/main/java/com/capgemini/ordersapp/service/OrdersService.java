package com.capgemini.ordersapp.service;

import java.util.List;

import com.capgemini.ordersapp.entity.Orders;
import com.capgemini.ordersapp.exception.OrderNotFoundException;

public interface OrdersService {

	public void deleteOrderById(long orderId);
	public List<Orders> getAllOrders();
	public Orders getOrderByOrderId(long orderId) throws OrderNotFoundException;
	public Orders addOrder(Orders orders);
	
}
