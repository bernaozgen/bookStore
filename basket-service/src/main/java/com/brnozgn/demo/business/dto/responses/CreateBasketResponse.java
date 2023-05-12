package com.brnozgn.demo.business.dto.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateBasketResponse {
	private String id;
	private String bookId;
	private int totalPcs;
	private int leadTime;
	private double totalPrice;
}
