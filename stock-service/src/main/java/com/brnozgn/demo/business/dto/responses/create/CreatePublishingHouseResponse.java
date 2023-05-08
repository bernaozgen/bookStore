package com.brnozgn.demo.business.dto.responses.create;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatePublishingHouseResponse {
	private String id;
	private String name;
	private String explication;
}
