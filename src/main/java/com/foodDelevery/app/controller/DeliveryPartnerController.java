package com.foodDelevery.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.foodDelevery.app.entity.DeliveryPartner;
import com.foodDelevery.app.service.DeliveryPartnerService;

@RestController
@RequestMapping("/api")
public class DeliveryPartnerController {

	@Autowired
	private DeliveryPartnerService deliveryPartnerService;
	
	@PostMapping("/add/deliveryPartner")
	public ResponseEntity<DeliveryPartner> addDeliveryPartnerHandler(@RequestBody DeliveryPartner deliveryPartner){
		DeliveryPartner res = deliveryPartnerService.addDeliveryPartner(deliveryPartner);
		return new ResponseEntity<DeliveryPartner>(res,HttpStatus.ACCEPTED);
	}
}
