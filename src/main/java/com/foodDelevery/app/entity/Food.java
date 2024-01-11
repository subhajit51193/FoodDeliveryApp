package com.foodDelevery.app.entity;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "food_details")
public class Food {

	@Id
	@Column(name = "food_id")
	private String food_id;
	
	@Column(name = "food_name")
	private String foodName;
	
	@Column(name = "food_price")
	private BigDecimal foodPrice;
	
	@Column(name = "url")
	private String url;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id")
	private Restaurant restaurant;
}
