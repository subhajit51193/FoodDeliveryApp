package com.foodDelevery.app.service;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodDelevery.app.entity.Address;
import com.foodDelevery.app.entity.DeliveryPartner;
import com.foodDelevery.app.helper.Helper;
import com.foodDelevery.app.repository.AddressRepository;
import com.foodDelevery.app.repository.DeliveryPartnerRepository;

@Service
public class DeliveryPartnerServiceImpl implements DeliveryPartnerService{

	@Autowired
	private DeliveryPartnerRepository deliveryPartnerRepository;
	
	@Autowired
	private AddressRepository addressRepository;
	
	@Autowired
	private Helper helper;
	
	/*
	 * Add DeliveryPartner
	 * 
	 * @param DeliveryPartner: DeliveryPartner object consisting partner data as well as
	 * address data
	 * 
	 * @return DeliveryPartner: Saved partner data
	 */
	@Override
	public DeliveryPartner addDeliveryPartner(DeliveryPartner deliveryPartner) {
		
		deliveryPartner.setDelivery_partner_id(helper.createRandomString());
		
		Set<Address> addresses = deliveryPartner.getAddresses();
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
			
			//Adding deliveryPartners and address into each other's list
			address.getPartners().add(deliveryPartner);
			deliveryPartner.getAddresses().add(address);
		}
		return deliveryPartnerRepository.save(deliveryPartner);
	}

}
