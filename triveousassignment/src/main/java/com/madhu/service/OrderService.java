package com.madhu.service;

import java.util.List;

import com.madhu.entity.SaleOrder;
import com.madhu.entity.User;
import com.madhu.exception.CartException;
import com.madhu.exception.OrderException;
import com.madhu.exception.UserException;

public interface OrderService {

	SaleOrder placeOrder(User user) throws UserException,CartException;

	List<SaleOrder> getOrderHistory(Integer userId) throws UserException, OrderException;

	SaleOrder getOrderByOrderId(Integer orderId) throws OrderException;

}
