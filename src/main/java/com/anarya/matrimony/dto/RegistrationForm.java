package com.anarya.matrimony.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RegistrationForm {

	@NotBlank(message = "Username cannot be blank")
	private String userName;

	@NotBlank(message = "Email cannot be blank")
	@Email(message = "Invalid email format")
	private String email;

	@NotNull(message = "Phone number cannot be null")
	private Long phno;

	@NotNull(message = "Age cannot be null")
	@Min(value = 18, message = "Age must be at least 18")
	private Integer age;

}