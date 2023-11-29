package com.madhu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.madhu.dto.CartDto;
import com.madhu.dto.UpdateCartDto;
import com.madhu.entity.Cart;
import com.madhu.exception.CartException;
import com.madhu.exception.ProductException;
import com.madhu.service.CartService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping("/cart")
@SecurityRequirement(name = "scheme1")
public class CartController {

	@Autowired
	private CartService cartService;

	@PostMapping("/addCart")
	ResponseEntity<Cart> addCart(@RequestBody CartDto cartDto) throws CartException, ProductException {

		return ResponseEntity.ok(cartService.addCart(cartDto));
	}

	@GetMapping("/getCartById/{cartId}")
	ResponseEntity<Cart> getCartByCartId(@PathVariable Integer cartId) throws CartException {
		return ResponseEntity.ok(cartService.getCartByCartId(cartId));
	}

	@DeleteMapping("/deleteCartById/{cartId}")
	ResponseEntity<Cart> deleteCartById(@PathVariable Integer cartId) throws CartException {
		return ResponseEntity.ok(cartService.deleteCartById(cartId));
	}

	@PutMapping("/updateProductQuantityInACart/{cartId}/{productId}")
	ResponseEntity<Cart> updateProductQuantityInACart(UpdateCartDto cartDto) throws CartException {
		return ResponseEntity.ok(cartService.updateProductQuantityInACart(cartDto.getCartId(), cartDto.getProductId(),
				cartDto.getQuantity()));
	}

}
