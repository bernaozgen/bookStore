package com.brnozgn.business.dto.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateInvoiceRequest {

	private String bookName;

	private int totalPcs;

	private double totalPrice;

}
