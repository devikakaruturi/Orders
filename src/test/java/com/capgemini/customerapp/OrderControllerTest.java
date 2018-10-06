package com.capgemini.customerapp;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import javax.persistence.criteria.Order;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.capgemini.ordersapp.controller.OrdersController;
import com.capgemini.ordersapp.entity.Orders;
import com.capgemini.ordersapp.service.OrdersService;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
public class OrderControllerTest {

	@Mock
	OrdersService ordersService;
	
	@InjectMocks 
	OrdersController ordersController;
	

	private MockMvc mockMvc;
	@Before
	public void setup()
	{
		MockitoAnnotations.initMocks(this);
		mockMvc=MockMvcBuilders.standaloneSetup(ordersController).build();
	}

	@Test
	public void testAddOrders() throws Exception
	{
		when(ordersService.addOrder(Mockito.isA(Orders.class))).thenReturn(new Orders(1234, "toy"));
		mockMvc.perform(post("/orders")
				.contentType(MediaType.APPLICATION_JSON_UTF8)
				.content("{\r\n" + 
						"  \"orderId\": \"1234\",\r\n" + 
						"  \"orderName\": \"toy\"\r\n" + 
						"}")
				.accept(MediaType.APPLICATION_JSON_UTF8))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.orderId").value(1234))
		.andDo(print());
	}
	
}
