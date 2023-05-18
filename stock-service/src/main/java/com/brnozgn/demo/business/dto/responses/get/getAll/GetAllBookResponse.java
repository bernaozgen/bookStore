package com.brnozgn.demo.business.dto.responses.get.getAll;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllBookResponse {
	private String id;
	private String bookName;
	private String novelistId;
	private String explication;
	private String comment;
	private double price;
	private String categoryId;
	private String publishingHouseId;
	private int stock;

}
