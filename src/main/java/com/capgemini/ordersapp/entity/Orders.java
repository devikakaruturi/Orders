package com.capgemini.ordersapp.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="orders")
public class Orders {
	@Id
	private long ordersId;
	private String ordersName;
	public long getOrderId() {
		return ordersId;
	}
	public void setOrderId(long ordersId) {
		this.ordersId = ordersId;
	}
	public String getOrderName() {
		return ordersName;
	}
	public void setOrderName(String ordersName) {
		this.ordersName = ordersName;
	}
	@Override
	public String toString() {
		return "Orders [ordersId=" + ordersId + ", ordersName=" + ordersName + "]";
	}
	public Orders(long ordersId, String ordersName) {
		super();
		this.ordersId = ordersId;
		this.ordersName = ordersName;
	}
	public Orders() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
}
