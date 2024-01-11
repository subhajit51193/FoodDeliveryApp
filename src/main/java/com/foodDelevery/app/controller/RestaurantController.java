package com.foodDelevery.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.foodDelevery.app.entity.Restaurant;
import com.foodDelevery.app.service.RestaurantService;

@RestController
@RequestMapping("/api/restaurant")
public class RestaurantController {

	@Autowired
	private RestaurantService restaurantService;
	
	@PostMapping("/add")
	public ResponseEntity<Restaurant> addRestaurantHandler(@RequestBody Restaurant restaurant){
		
		Restaurant res = restaurantService.addRestaurant(restaurant);
		return new ResponseEntity<Restaurant>(res,HttpStatus.ACCEPTED);
	}
}
