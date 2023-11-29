package com.madhu.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.madhu.entity.Cart;
import com.madhu.entity.SaleOrder;
import com.madhu.entity.User;
import com.madhu.exception.CartException;
import com.madhu.exception.OrderException;
import com.madhu.exception.UserException;
import com.madhu.repository.CartRepository;
import com.madhu.repository.OrderRepository;
import com.madhu.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepo;

	@Autowired
	private UserService userService;
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private CartRepository cartRepo;
	

	@Override
	public SaleOrder placeOrder(User user) throws UserException, CartException {

		Cart cart = userService.getCartById(user.getUserId());

		var order = new SaleOrder();

	
		order.setTimestamp(LocalDateTime.now());
		order.setUser(user);
		order.setCart(cart);
		
		System.out.println("The cart size going to delete is  "+cart.getCartItems().size());

		cartRepo.deleteAll();
		
		user.setCart(new Cart());
		
		user.setIsCartActive(false);
		
		userRepo.save(user);

		return orderRepo.save(order);

	}

	@Override
	public List<SaleOrder> getOrderHistory(Integer userId) throws UserException, OrderException {
		var orders = orderRepo.findByUserUserId(userId);
		
		if(orders.isEmpty())
			throw new OrderException("No Orders Found");
		
		return orders;
	}

	@Override
	public SaleOrder getOrderByOrderId(Integer orderId) throws OrderException {
		return orderRepo.findById(orderId)
				.orElseThrow(()->new OrderException("Order Not Found with Id "+orderId));
	}

}
