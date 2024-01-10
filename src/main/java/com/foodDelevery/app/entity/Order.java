package com.foodDelevery.app.entity;

import com.foodDelevery.app.enums.OrderStatus;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "order_details")
public class Order {

	@Id
	@Column(name = "order_id")
	private String order_id;
	
	@Column(name = "customer_id")
	private String customerId;
	
	@Column(name = "restaurant_id")
	private String restaurantId;
	
	@Column(name = "delivery_partner_id")
	private String deliveryPartnerId;
	
	@Column(name = "customer_name")
	private String name;
	
	@Column(name = "email")
	private String email;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id", referencedColumnName = "address_id")
	private Address address;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cart_id", referencedColumnName = "cart_id")
	private Cart cart;
	
	private OrderStatus orderStatus;
}
