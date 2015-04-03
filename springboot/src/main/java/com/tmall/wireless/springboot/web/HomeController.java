package com.tmall.wireless.springboot.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tmall.wireless.springboot.domain.Customer;
import com.tmall.wireless.springboot.service.CustomerService;


@RestController
public class HomeController {

	
	@RequestMapping("/")
	public String home(){
		return "Hello World";
	}
	
	@RequestMapping("/customer")
	public Customer customer(){
		return customerService.getCustomer("ljinshuan", 24);
	}
	
	@Resource
	private CustomerService customerService;
}
