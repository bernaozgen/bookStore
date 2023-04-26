package com.brnozgn.demo.business.dto.requests.update;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCategoryRequest {
	@NotEmpty
	@NotNull
	@Size(min = 16, max = 16, message = "id size must be 16 digits")
	private String id;

	@NotEmpty
	@NotNull
	@Min(4)
	private String name;

}
