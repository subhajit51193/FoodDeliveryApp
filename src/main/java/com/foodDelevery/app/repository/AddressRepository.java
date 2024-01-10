package com.foodDelevery.app.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.foodDelevery.app.entity.Address;

public interface AddressRepository extends JpaRepository<Address, String>{
	
	/*
	 * return particular address if exists with given properties
	 */
	@Query("FROM Address a WHERE a.houseNo=?1 AND a.streetName=?2 AND a.pinCode=?3 AND a.landmark=?4")
	public Optional<Address> findByDetails(String houseNo,String streetName,String pinCode,String landmark);
}
