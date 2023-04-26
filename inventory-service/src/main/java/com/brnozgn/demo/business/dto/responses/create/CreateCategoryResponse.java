package com.brnozgn.demo.business.dto.responses.create;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCategoryResponse {
	private String cId;
	private String name;
}
