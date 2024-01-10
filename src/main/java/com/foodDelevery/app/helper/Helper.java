package com.foodDelevery.app.helper;

import java.util.UUID;

import org.springframework.stereotype.Component;

import com.foodDelevery.app.dto.CustomerDTO;
import com.foodDelevery.app.entity.Customer;

@Component
public class Helper {

	/*
	 * creates random unique string
	 * 
	 * @return String : unique string
	 */
	public String createRandomString() {
		
		String res = UUID.randomUUID().toString();
		return res;
	}
	
	/*
	 * Converts Customer object to CustomerDTO
	 * 
	 * @param Customer : Customer object 
	 * 
	 * @return CustomerDTO : CustomerDTO object
	 */
	public CustomerDTO convertToCustomerDTO(Customer customer) {
		
		CustomerDTO dto = CustomerDTO.builder()
				.customer_id(customer.getCustomer_id())
				.customerName(customer.getCustomerName())
				.email(customer.getEmail())
				.phoneNumber(customer.getPhoneNumber())
				.url(customer.getUrl())
				.addresses(customer.getAddresses())
				.build();
		return dto;
	}
}
