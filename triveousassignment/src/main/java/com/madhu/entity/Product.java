package com.madhu.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer productId;

	private String productTitle;

	private String productDescription;
	
	@JsonBackReference
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "product")
	private List<CartItem> cartItems = new ArrayList<CartItem>();
	
	@JsonBackReference
	@ManyToOne
	private Category category;

}
