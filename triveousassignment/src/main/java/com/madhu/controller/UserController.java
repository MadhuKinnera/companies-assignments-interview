package com.madhu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.madhu.dto.UserDto;
import com.madhu.entity.User;
import com.madhu.exception.UserException;
import com.madhu.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/createUser")
	ResponseEntity<User> createUser(@RequestBody UserDto userDto) throws UserException {

		return ResponseEntity.ok(userService.createUser(userDto));
	}

}
