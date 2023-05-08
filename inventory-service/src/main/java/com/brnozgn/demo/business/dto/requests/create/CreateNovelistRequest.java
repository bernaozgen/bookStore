package com.brnozgn.demo.business.dto.requests.create;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateNovelistRequest {

	
	private String name;
	private String surname;
	private String summary;
}
