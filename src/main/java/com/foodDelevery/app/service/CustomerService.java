package com.foodDelevery.app.service;

import com.foodDelevery.app.dto.CustomerDTO;
import com.foodDelevery.app.entity.Customer;
import com.foodDelevery.app.exception.CustomerNotFoundException;

public interface CustomerService {

	public Customer addCustomer(Customer customer); 
	
	public CustomerDTO getCustomerById(String customerId)throws CustomerNotFoundException;
}
