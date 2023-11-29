package com.madhu.dto;

import lombok.Data;

@Data
public class UpdateCartDto {
	
	private Integer cartId;
	private Integer productId;
	private Integer quantity;

}
