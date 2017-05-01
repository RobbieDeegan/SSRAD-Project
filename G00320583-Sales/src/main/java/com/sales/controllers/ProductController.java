package com.sales.controllers;

import java.util.LinkedList;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sales.models.Product;
import com.sales.services.ProductService;

@Controller
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@RequestMapping(value = "/ProductDisplay", method = RequestMethod.GET)
	public String showProduct(Model m){
		
		LinkedList<Product> products = productService.getAll();
		m.addAttribute("products", products);
		return "ProductDisplay";
	}
	
	@RequestMapping(value = "/AddProduct", method = RequestMethod.GET)
	public String getProduct(@ModelAttribute("product1") Product product, HttpServletRequest http){
		
		return "AddProduct";
	}
	
	@RequestMapping(value = "/AddProduct", method = RequestMethod.POST)
	public String postProduct(@Valid @ModelAttribute("product1") Product product, BindingResult result, HttpServletRequest http, Model m){

		if (result.hasErrors())
		{	
			return "AddProduct";
		}
		else 
		{
			productService.save(product);
			LinkedList<Product> products = productService.getAll();
			m.addAttribute("products", products);
			return "ProductDisplay";
		}
	}
}