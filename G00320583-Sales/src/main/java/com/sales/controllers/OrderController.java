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

import com.sales.models.Order;
import com.sales.services.OrderService;

@Controller
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@RequestMapping(value = "/OrderDisplay", method = RequestMethod.GET)
	public String showOrder(Model m){
		
		LinkedList<Order> orders = orderService.getAll();
		m.addAttribute("orders", orders);
		return "OrderDisplay";
	}
	
	@RequestMapping(value = "/AddOrder", method = RequestMethod.GET)
	public String getOrder(@ModelAttribute("order1") Order ord, HttpServletRequest http){
		
		return "AddOrder";
	}
	
	@RequestMapping(value = "/AddOrder", method = RequestMethod.POST)
	public String postOrder(@Valid @ModelAttribute("order1") Order order, BindingResult result, HttpServletRequest http, Model m) throws Exception{
		
		if(result.hasErrors())
		{
			return "AddOrder";
		}
		else
		{
			orderService.save(order);
			LinkedList<Order> orders = orderService.getAll();
			m.addAttribute("orders", orders);
			return "OrderDisplay";
		}
	}
}