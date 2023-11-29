package com.madhu.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class Cart {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer cartId;
	

	@OneToMany(mappedBy = "cart",fetch = FetchType.EAGER,cascade = CascadeType.ALL,orphanRemoval = true)
	private List<CartItem> cartItems = new ArrayList<CartItem>();
	
	@JsonBackReference
	@OneToOne
	private User user;
	
	@JsonBackReference
	@OneToOne(mappedBy = "cart")
	private SaleOrder order;
	

	

}
