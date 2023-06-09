package com.brnozgn.demo.business.dto.responses.get.getById;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetByNovelistIdResponse {
	private String id;
	private String name;
	private String surname;
	private String summary;
}
