package com.foodDelevery.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.foodDelevery.app.dto.CustomerDTO;
import com.foodDelevery.app.entity.Customer;
import com.foodDelevery.app.exception.CustomerNotFoundException;
import com.foodDelevery.app.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@PostMapping("/customer/add")
	public ResponseEntity<Customer> addCustomerHandler(@RequestBody Customer customner){
		Customer res = customerService.addCustomer(customner);
		return new ResponseEntity<Customer>(res,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/customer/{id}")
	public ResponseEntity<CustomerDTO> getCustomerByIdHandler(@PathVariable("id") String customerId) throws CustomerNotFoundException{
		CustomerDTO res = customerService.getCustomerById(customerId);
		return new ResponseEntity<CustomerDTO>(res,HttpStatus.OK);
	}
}
