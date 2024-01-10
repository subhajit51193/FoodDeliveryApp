package com.foodDelevery.app.entity;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "address_details")
public class Address {

	@Id
	@Column(name = "address_id")
	private String address_id;
	
	@Column(name = "house_no")
	private String houseNo;
	
	@Column(name = "street_name")
	private String streetName;
	
	@Column(name = "pin")
	private String pinCode;
	
	@Column(name = "landmark")
	private String landmark;
	
	@JsonIgnore
	@ManyToMany(cascade = {
			CascadeType.PERSIST,
			CascadeType.MERGE
	}, fetch = FetchType.EAGER,
	mappedBy = "addresses")
	private Set<Customer> customers = new HashSet<>();
	
	@JsonIgnore
	@ManyToMany(cascade = {
			CascadeType.PERSIST,
			CascadeType.MERGE
	}, fetch = FetchType.EAGER,
	mappedBy = "addresses")
	private Set<DeliveryPartner> partners = new HashSet<>();
	
	@JsonIgnore
	@ManyToMany(cascade = {
			CascadeType.PERSIST,
			CascadeType.MERGE
	}, fetch = FetchType.EAGER,
	mappedBy = "addresses")
	private Set<Restaurant> restaurants = new HashSet<>();
}
