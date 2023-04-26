package com.brnozgn.demo.business.dto.requests.update;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateNovelistRequest {

	@NotEmpty
	@NotNull
	private String nId;

	@NotEmpty
	@NotNull
	private String name;

	@NotEmpty
	@NotNull
	private String surname;

	@NotEmpty
	@NotNull
	@Size(min = 5)
	private String summary;
}
