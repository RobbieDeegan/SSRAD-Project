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

import com.sales.models.Customer;
import com.sales.services.CustomerService;

@Controller
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@RequestMapping(value = "/CustomerDisplay", method = RequestMethod.GET)
	public String showCustomer(Model m){
		
		LinkedList<Customer> customers = customerService.getAll();
		m.addAttribute("customers", customers);
		return "CustomerDisplay";
	}
	
	@RequestMapping(value = "/AddCustomer", method = RequestMethod.GET)
	public String getCustomer(@ModelAttribute("customer1") Customer customer, HttpServletRequest http){
		
		return "AddCustomer";
	}
	
	@RequestMapping(value = "/AddCustomer", method = RequestMethod.POST)
	public String postCustomer(@Valid @ModelAttribute("customer1") Customer customer, BindingResult result, HttpServletRequest http, Model m){

		if (result.hasErrors()) 
		{
			return "AddCustomer";
		}
		else 
		{
			customerService.save(customer);
			LinkedList<Customer> customers = customerService.getAll();
			m.addAttribute("customers", customers);
			return "CustomerDisplay";
		}
	}
}