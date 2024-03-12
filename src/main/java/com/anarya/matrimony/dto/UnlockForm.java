package com.anarya.matrimony.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UnlockForm {

	@NotBlank(message = "This field should not be empty")
	private String tempPassword;

	@NotBlank(message = "This field should not be empty")
	private String newPassword;

	@NotBlank(message = "This field should not be empty")
	private String confirmPassword;

	@NotBlank(message = "This field should not be empty")
	private String email;

}
