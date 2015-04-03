package com.tmall.wireless.springboot.service;

import org.springframework.stereotype.Service;

import com.tmall.wireless.springboot.domain.Customer;

@Service
public class CustomerService {

	
	public Customer getCustomer(String name,int age){
		return new Customer(name, age);
	}
}
