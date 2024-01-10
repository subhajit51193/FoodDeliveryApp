package com.foodDelevery.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.foodDelevery.app.entity.Cart;

public interface CartRepository extends JpaRepository<Cart, String>{

}
