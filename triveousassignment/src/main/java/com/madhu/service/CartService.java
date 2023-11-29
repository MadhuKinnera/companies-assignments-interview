package com.madhu.service;

import com.madhu.dto.CartDto;
import com.madhu.entity.Cart;
import com.madhu.exception.CartException;
import com.madhu.exception.ProductException;

public interface CartService {

	Cart addCart(CartDto cartDto) throws CartException,ProductException;

	Cart getCartByCartId(Integer cartId) throws CartException;

	Cart deleteCartById(Integer cartId) throws CartException;

	Cart updateProductQuantityInACart(Integer cartId, Integer productId, Integer quanity) throws CartException;

}
