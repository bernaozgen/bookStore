package com.brnozgn.demo.business.dto.responses.get.getAll;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllNovelistResponse {
	private String nId;
	private String name;
	private String surname;
	private String summary;

}
