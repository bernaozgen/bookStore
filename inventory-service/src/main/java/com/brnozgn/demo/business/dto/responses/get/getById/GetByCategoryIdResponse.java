package com.brnozgn.demo.business.dto.responses.get.getById;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByCategoryIdResponse {

	private String cId;
	private String name;
}
