package com.sales.services;

import java.util.LinkedList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sales.models.Customer;
import com.sales.repositories.CustomerInterface;

@Service
public class CustomerService {

	@Autowired
	private CustomerInterface customerinterface;
	
	// Return all customers
	public LinkedList<Customer> getAll(){
		
		return (LinkedList <Customer>) customerinterface.findAll();
	}
	
	// Save a new Customer
	public Customer save(Customer customer){
		
		return customerinterface.save(customer);
	}
	
}