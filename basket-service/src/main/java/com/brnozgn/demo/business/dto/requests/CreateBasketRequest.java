package com.brnozgn.demo.business.dto.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateBasketRequest {

	private String bookId;
	private int totalPcs;
	private int leadTime;
	private double totalPrice;
}
