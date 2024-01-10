package com.foodDelevery.app.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "delivery_partner_details")
public class DeliveryPartner {

	@Id
	@Column(name = "delivery_partner_id")
	private String delivery_partner_id;
	
	@Column(name = "delivery_partner_name")
	private String deliveryPartnerName;
	
	@Column(name = "phone_number")
	private String phoneNumber;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "url")
	private String url;
	
	@ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinTable(
			name = "partner_address",
			joinColumns = @JoinColumn(
					name = "delivery_partner_id",referencedColumnName = "delivery_partner_id"
					),
			inverseJoinColumns = @JoinColumn(
					name = "address_id", referencedColumnName = "address_id"
					)
			)
	private Set<Address> addresses = new HashSet<>();
}
