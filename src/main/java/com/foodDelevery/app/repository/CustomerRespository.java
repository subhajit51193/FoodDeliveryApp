package com.foodDelevery.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.foodDelevery.app.entity.Customer;

public interface CustomerRespository extends JpaRepository<Customer, String>{

}
