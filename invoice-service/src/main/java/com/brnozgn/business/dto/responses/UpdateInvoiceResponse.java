package com.brnozgn.business.dto.responses;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateInvoiceResponse {
	private UUID id;

	private String bookName;

	private int totalPcs;

	private double totalPrice;
}
