package com.ceshi.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ceshi.model.Customer;
import com.ceshi.service.ICusManager;



@Controller
public class CustomerController {

	@Autowired
	ICusManager cusManager ;
	Customer customer;
	
	
	public ICusManager getCusManager() {
		return cusManager;
	}


	public void setCusManager(ICusManager cusManager) {
		this.cusManager = cusManager;
	}


	@RequestMapping("/add")
	public String saveCustomer(HttpServletRequest request){
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		String username = request.getParameter("username");
		
		String password = request.getParameter("password");
		
		customer = new Customer();
		customer.setId(id);
		customer.setUsername(username);
		customer.setPassword(password);
		cusManager.insertCus(customer);
	
		return "success";
	}
}
