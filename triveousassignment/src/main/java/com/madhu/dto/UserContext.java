package com.madhu.dto;

import org.springframework.stereotype.Component;

import com.madhu.entity.User;

import lombok.Data;

@Component
@Data
public class UserContext {
	
	private User user;

}
