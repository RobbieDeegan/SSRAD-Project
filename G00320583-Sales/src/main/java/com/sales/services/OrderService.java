package com.sales.services;

import java.util.LinkedList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sales.models.Order;
import com.sales.repositories.OrderInterface;

@Service
public class OrderService {

	@Autowired
	private OrderInterface orderservice;
	
	// Return all Orders
	public LinkedList<Order> getAll(){
		
		return (LinkedList <Order>) orderservice.findAll();
	}
	
	// Save a new Order
	public Order save(Order order){
		
		return orderservice.save(order);
	}
	
}