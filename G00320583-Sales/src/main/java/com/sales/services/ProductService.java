package com.sales.services;

import java.util.LinkedList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sales.models.Product;
import com.sales.repositories.ProductInterface;

@Service
public class ProductService {

	@Autowired
	private ProductInterface productinterface;
	
	// Return all Products
	public LinkedList<Product> getAll(){
		
		return (LinkedList<Product>) productinterface.findAll();
	}
	
	// Save a new Product
	public Product save(Product pro){
		
		return productinterface.save(pro);
	}
}