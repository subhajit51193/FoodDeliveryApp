package com.foodDelevery.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.foodDelevery.app.entity.Food;

public interface FoodRepository extends JpaRepository<Food, String>{

}
