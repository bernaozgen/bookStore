package com.brnozgn.demo.business.dto.requests.create;



import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreatePublishingHouseRequest {

	@NotEmpty
	@NotNull
	@Size(min = 4, message = "must be a minimum of 4 words")
	private String name;
	@NotEmpty
	@NotNull
	@Size(min = 4, message = "must be a minimum of 4 words")
	private String explication;
}
