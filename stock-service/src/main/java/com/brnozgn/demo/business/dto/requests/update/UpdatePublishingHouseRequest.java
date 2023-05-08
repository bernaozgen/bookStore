package com.brnozgn.demo.business.dto.requests.update;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdatePublishingHouseRequest {
	private String id;
	private String name;
	private String explication;
}
