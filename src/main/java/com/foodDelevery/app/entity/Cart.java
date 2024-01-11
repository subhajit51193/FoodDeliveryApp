package com.foodDelevery.app.entity;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "cart_details")
public class Cart {

	@Id
	@Column(name = "cart_id")
	private String cart_id;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(
			name = "carts_foods",
			joinColumns = @JoinColumn(
					name = "cart_id", referencedColumnName = "cart_id"
			),
			inverseJoinColumns = @JoinColumn(
					name = "food_id",referencedColumnName = "food_id"
					)
	)
	private Set<Food> foods = new HashSet<>();
	
	@Column(name = "total_price")
	private Long totalPrice;
	
	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "cart", fetch = FetchType.LAZY)
	private Customer customer;
}
