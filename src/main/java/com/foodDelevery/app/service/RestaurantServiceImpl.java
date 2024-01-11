package com.foodDelevery.app.service;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodDelevery.app.entity.Address;
import com.foodDelevery.app.entity.Food;
import com.foodDelevery.app.entity.Restaurant;
import com.foodDelevery.app.helper.Helper;
import com.foodDelevery.app.repository.AddressRepository;
import com.foodDelevery.app.repository.RestaurantRepository;

@Service
public class RestaurantServiceImpl implements RestaurantService{

	@Autowired
	private RestaurantRepository restaurantRepository;
	
	@Autowired
	private Helper helper;
	
	@Autowired
	private AddressRepository addressRepository;
	
	@Override
	public Restaurant addRestaurant(Restaurant restaurant) {
		
		restaurant.setRestaurant_id(helper.createRandomString());
		
		Set<Address> addresses = restaurant.getAddresses();
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
			
			//Adding restaurant and address into each other's list
			address.getRestaurants().add(restaurant);
			
			restaurant.getAddresses().add(address);
			
		}
		Set<Food> foods = restaurant.getFoods();
		
		for (Food food: foods) {
			//creating an id for food and setting it into restaurant and vice versa
			food.setFood_id(helper.createRandomString());
			food.setRestaurant(restaurant);
			restaurant.getFoods().add(food);
//			foodRepository.save(food);
		}
		return restaurantRepository.save(restaurant);
	}

}
