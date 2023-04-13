package com.brnozgn.demo.business.dto.requests.create;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateBookRequest {

	@NotEmpty
	@NotNull
	private String bookName;
	@NotEmpty
	@NotNull
	private String novelistId;
	@NotEmpty
	@NotNull
	private String explication;
	@NotEmpty
	@NotNull
	private String comment;
	@NotNull
	private double price;
	@NotEmpty
	@NotNull
	private String categoryId;
	@NotEmpty
	@NotNull
	private String publishingHouseId;
}
