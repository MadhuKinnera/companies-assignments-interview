package com.madhu.service;

import com.madhu.dto.UserDto;
import com.madhu.entity.Cart;
import com.madhu.entity.User;
import com.madhu.exception.CartException;
import com.madhu.exception.UserException;

public interface UserService {

	User createUser(UserDto userDto) throws UserException;
	
	Cart getCartById(Integer userId) throws UserException,CartException;
	
	User clearCart(Integer userId)throws UserException,CartException;

}
