package com.madhu.service;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.madhu.dto.CartDto;
import com.madhu.dto.CartItemDto;
import com.madhu.dto.UserContext;
import com.madhu.entity.Cart;
import com.madhu.entity.CartItem;
import com.madhu.exception.CartException;
import com.madhu.exception.ProductException;
import com.madhu.repository.CartItemRepository;
import com.madhu.repository.CartRepository;
import com.madhu.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CartServiceImpl implements CartService {

	@Autowired
	private UserContext context;

	@Autowired
	private CartRepository cartRepo;

	@Autowired
	private CartItemRepository cartItemRepo;

	@Autowired
	private ProductService productService;

	@Autowired
	private UserRepository userRepo;

	@Override
	public Cart addCart(CartDto cartDto) throws CartException, ProductException {

		Cart cart = null;

		var user = context.getUser();

		if (user.getIsCartActive()) {
			cart = cartRepo.findByUserUserId(user.getUserId())
					.orElseThrow(() -> new CartException("Cart Not Found with User Id " + user.getUserId()));
		} else {
			cart = new Cart();
		}

		System.out.println("The cart is " + cart);

		cart.setUser(user);

		boolean isAdding = false;

		for (CartItemDto cItem : cartDto.getCartItems()) {

			isAdding = true;
			var cartItem = new CartItem();

			var product = productService.getProductByProductId(cItem.getProductId());

			cartItem.setProduct(product);
			cartItem.setQuantity(cItem.getQuantity());

			var cartItems = cart.getCartItems();

			var alreadyPresentProducts = cartItems.stream()
					.filter(item -> item.getProduct().getProductId().equals(cItem.getProductId())).toList();

			System.out.println("The products already present is " + alreadyPresentProducts.size());
			if (!alreadyPresentProducts.isEmpty()) {
				throw new ProductException("Product Already Present Change Quntity ");
			}

			cart.getCartItems().add(cartItem);

			cartItem.setCart(cart);

			cartItemRepo.save(cartItem);

		}

		if (isAdding) {
			user.setIsCartActive(true);

			userRepo.save(user);
		}

		return cartRepo.save(cart);
	}

	@Override
	public Cart getCartByCartId(Integer cartId) throws CartException {
		return cartRepo.findById(cartId).orElseThrow(() -> new CartException("Cart Not Found with Cart Id " + cartId));
	}

	@Override
	public Cart deleteCartById(Integer cartId) throws CartException {

		var cart = getCartByCartId(cartId);

		cartRepo.delete(cart);

		return cart;
	}

	@Override
	public Cart updateProductQuantityInACart(Integer cartId, Integer productId, Integer quanity) throws CartException {

		var cart = getCartByCartId(cartId);

		for (CartItem cItem : cart.getCartItems()) {
			if (cItem.getProduct().getProductId().equals(productId)) {
				cItem.setQuantity(quanity);
				break;
			}
		}

		return cartRepo.save(cart);
	}

}
