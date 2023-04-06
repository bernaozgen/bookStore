package com.brnozgn.demo.business.dto.responses.update;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdatePublishingHouseResponse {
	private String id;
	private String name;
	private String explication;
}
