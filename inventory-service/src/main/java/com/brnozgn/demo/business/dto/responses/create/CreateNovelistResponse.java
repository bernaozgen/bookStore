package com.brnozgn.demo.business.dto.responses.create;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateNovelistResponse {
	private String id;
	private String name;
	private String surname;
	private String summary;
}
