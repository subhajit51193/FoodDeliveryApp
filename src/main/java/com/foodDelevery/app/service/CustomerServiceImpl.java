package com.foodDelevery.app.service;


import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodDelevery.app.dto.CustomerDTO;
import com.foodDelevery.app.entity.Address;
import com.foodDelevery.app.entity.Customer;
import com.foodDelevery.app.exception.CustomerNotFoundException;
import com.foodDelevery.app.helper.Helper;
import com.foodDelevery.app.repository.AddressRepository;
import com.foodDelevery.app.repository.CustomerRespository;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerRespository customerRespository;
	
	@Autowired
	private AddressRepository addressRepository;
	
	@Autowired
	private Helper helper;
	
	/*
	 * Add Customer
	 * 
	 * @param Customer: Customer object consisting customer data as well as
	 * address data
	 * 
	 * @return Customer: Saved customer data
	 */
	@Override
	public Customer addCustomer(Customer customer) {
		
		customer.setCustomer_id(helper.createRandomString());
		
		Set<Address> addresses = customer.getAddresses();
		for (Address address : addresses) {
			
			//Checking if address already exists with required details
			Optional<Address> opt = addressRepository.findByDetails(address.getHouseNo(), address.getStreetName(), 
					address.getPinCode(), address.getLandmark());
			
			//If no such address found then setting new id to create new object
			if (opt.isEmpty()) {
				address.setAddress_id(helper.createRandomString());
				
			}
			
			//If such address found then setting setting existing id and update the data
			else {
				Address existingAddress = opt.get();
				address.setAddress_id(existingAddress.getAddress_id());
			}
			
			//Adding customers and address into each other's list
			address.getCustomers().add(customer);
			customer.getAddresses().add(address);
		}
		return customerRespository.save(customer);
	}

	@Override
	public CustomerDTO getCustomerById(String customerId) throws CustomerNotFoundException {
		
		Optional<Customer> opt = customerRespository.findById(customerId);
		if (opt.isEmpty()) {
			throw new CustomerNotFoundException("Customer not found with selected ID -> "+customerId);
		}
		Customer cst = opt.get();
		CustomerDTO dto = helper.convertToCustomerDTO(cst);
		return dto;
	}
}
