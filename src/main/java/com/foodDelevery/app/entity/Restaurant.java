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
import jakarta.persistence.OneToMany;
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
@Table(name = "restaurant_details")
public class Restaurant {

	@Id
	@Column(name = "restaurant_id")
	private String restaurant_id;
	
	@Column(name = "restaurant_name")
	private String restaurantName;
	
	@ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinTable(
			name = "restaurant_address",
			joinColumns = @JoinColumn(
					name = "restaurant_id",referencedColumnName = "restaurant_id"
					),
			inverseJoinColumns = @JoinColumn(
					name = "address_id", referencedColumnName = "address_id"
					)
			)
	private Set<Address> addresses = new HashSet<>();
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "restaurant")
	private Set<Food> foods = new HashSet<>();
	
	
}
