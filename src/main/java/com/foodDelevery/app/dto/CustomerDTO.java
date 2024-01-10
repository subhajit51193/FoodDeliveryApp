package com.foodDelevery.app.dto;

import java.util.HashSet;
import java.util.Set;

import com.foodDelevery.app.entity.Address;
import com.foodDelevery.app.entity.Cart;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class CustomerDTO {

	private String customer_id;
	private String customerName;
	private String email;
	private String phoneNumber;
	private String url;
	private Set<Address> addresses = new HashSet<>();
	
}
