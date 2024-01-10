package com.foodDelevery.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.foodDelevery.app.entity.DeliveryPartner;

public interface DeliveryPartnerRepository extends JpaRepository<DeliveryPartner, String>{

}
