package com.madhu.entity;

import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
//@Entity
public class User {

	private Integer userId;
	private String email;
	private String password;
	private String role;
}
