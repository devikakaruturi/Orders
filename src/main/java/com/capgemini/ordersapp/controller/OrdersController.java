package com.capgemini.ordersapp.controller;



import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.ordersapp.entity.Orders;
import com.capgemini.ordersapp.exception.OrderNotFoundException;
import com.capgemini.ordersapp.service.OrdersService;

@RestController
public class OrdersController {

	private static final Logger LOGGER = LoggerFactory.getLogger(OrdersController.class);
	@Autowired
	private OrdersService ordersService;
	
	
	@PostMapping("/orders")
	public ResponseEntity<Orders> addOrder (@RequestBody Orders orders)
	{
		ResponseEntity<Orders> responseEntity = new ResponseEntity<Orders>(ordersService.addOrder(orders),HttpStatus.OK);
		LOGGER.info("goooooot   myyyyy ORDERRRRRRRRRRRRRRRRRR" +" "+responseEntity.getBody());
		return responseEntity;
	}
	
	
	@GetMapping("/orders/{ordersId}")
	public ResponseEntity<Orders> getOrderByOrderId(@PathVariable long ordersId) throws OrderNotFoundException
	{
		ResponseEntity<Orders> responseEntity = new ResponseEntity<Orders>(ordersService.getOrderByOrderId(ordersId),HttpStatus.OK);
		return responseEntity;
	}
	
	@DeleteMapping("/orders/{ordersId}")
	public void deleteOrderById(@PathVariable long ordersId)
	{
		ordersService.deleteOrderById(ordersId);
	}
	
	
	@GetMapping("/orders")
	public List<Orders> getAllOrders()
	{
		return ordersService.getAllOrders();
	}
}
