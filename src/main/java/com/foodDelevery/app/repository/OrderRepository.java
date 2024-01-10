package com.foodDelevery.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.foodDelevery.app.entity.Order;

public interface OrderRepository extends JpaRepository<Order, String>{

}
