package com.capgemini.ordersapp.client;

import org.springframework.web.client.RestTemplate;

import com.capgemini.ordersapp.entity.Orders;


public class OrdersControllerRestTemplateClient1 {
	
	private static final RestTemplate REST_TEMPLATE = new RestTemplate();
	private static final String baseUrl = "http://localhost:9090/";
	
	public static void main(String[] args) {
		
		//Adding a new product into database.
		String url = baseUrl + "orders";
		Orders orders= new Orders(1234, "toy");
		orders = addOrder(url, orders);
		System.out.println("After saving order into dababase : " + orders);
		
		orders= new Orders(1235, "flower");
		orders = addOrder(url, orders);
		System.out.println("After saving order into dababase : " + orders);
		
		orders= new Orders(1236, "chocolate");
		orders = addOrder(url, orders);
		System.out.println("After saving order into dababase : " + orders);
		
		/*//Getting product from database
		String url = baseUrl + "/products/102";
		Product product = findProductById(url);
		System.out.println("Product from DB : " + product);*/
		
		// Deleting product from database
		url = baseUrl + "orders/1234";		
		deleteOrders(url);
		
		//Updating product into database
		/*url = baseUrl + "order";
		Orders order = new Orders(1234, "toyssss");
		updateOrder(url, order);*/
	}

	/*public static void updateOrder(String url, Orders order) {
		 REST_TEMPLATE.put(url, order);
		 System.out.println("--success--");
	}*/

	public static void deleteOrders(String url) {
		REST_TEMPLATE.delete(url);
		System.out.println("--success--");
	}

	/*public static Product findProductById(String url) {
		return REST_TEMPLATE.getForObject(url, Product.class);
	}
*/
	public static Orders addOrder(String url, Orders orders) {
		Orders ordersAfterSavingIntoDb =  REST_TEMPLATE.postForObject(url, orders, Orders.class);
		System.out.println("--success--");
		return ordersAfterSavingIntoDb;
				
	}
}
