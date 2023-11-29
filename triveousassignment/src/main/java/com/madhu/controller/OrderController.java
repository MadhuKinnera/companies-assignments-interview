package com.madhu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.madhu.dto.UserContext;
import com.madhu.entity.SaleOrder;
import com.madhu.exception.CartException;
import com.madhu.exception.OrderException;
import com.madhu.exception.UserException;
import com.madhu.service.OrderService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping("/order")
@SecurityRequirement(name = "scheme1")
public class OrderController {

	@Autowired
	private OrderService orderService;

	@Autowired
	private UserContext context;

	@PostMapping("/placeOrder")
	ResponseEntity<SaleOrder> placeOrder() throws UserException, CartException {
		return ResponseEntity.ok(orderService.placeOrder(context.getUser()));
	}

	@GetMapping("/getOrderHistory")
	ResponseEntity<List<SaleOrder>> getOrderHistory() throws UserException, OrderException {

		return ResponseEntity.ok(orderService.getOrderHistory(context.getUser().getUserId()));
	}

	@GetMapping("/getOrderById/{orderId}")
	ResponseEntity<SaleOrder> getOrderByOrderId(@PathVariable  Integer orderId) throws OrderException {
		return ResponseEntity.ok(orderService.getOrderByOrderId(orderId));
	}

}
