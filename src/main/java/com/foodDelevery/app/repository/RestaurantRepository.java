package com.foodDelevery.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.foodDelevery.app.entity.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant, String>{

}
