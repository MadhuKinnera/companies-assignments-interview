package com.madhu.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.UniqueConstraint;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer userId;
	private String userName;
	
	@JsonProperty(access = Access.WRITE_ONLY)
	private String password;
	@Column(unique = true)
	private String email;
	
	
	@JsonBackReference
	@OneToOne(cascade = CascadeType.ALL,mappedBy = "user")
	private Cart cart = new Cart();
	
	private Boolean isCartActive = false;
	
	@JsonBackReference
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "user")
	private List<SaleOrder> orders = new  ArrayList<>();

}
