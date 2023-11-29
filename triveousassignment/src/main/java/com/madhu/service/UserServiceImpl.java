package com.madhu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.madhu.dto.UserDto;
import com.madhu.entity.Cart;
import com.madhu.entity.User;
import com.madhu.exception.CartException;
import com.madhu.exception.UserException;
import com.madhu.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private PasswordEncoder encoder;

	@Override
	public User createUser(UserDto userDto) throws UserException {
		var user = new User();

		user.setEmail(userDto.getEmail());
		user.setPassword(encoder.encode(userDto.getPassword()));
		user.setUserName(userDto.getUserName());

		return userRepo.save(user);
	}

	@Override
	public Cart getCartById(Integer userId) throws UserException, CartException {
		User user = userRepo.findById(userId).orElseThrow(() -> new UserException("User Not Found with Id " + userId));

		if (user.getCart() == null)
			throw new CartException("Cart is Empty");

		return user.getCart();
	}

	@Override
	public User clearCart(Integer userId) throws UserException, CartException {
		var user = userRepo.findById(userId).orElseThrow(() -> new UserException("User Not Found with Id " + userId));

		user.setCart(null);

		return userRepo.save(user);

	}

}
