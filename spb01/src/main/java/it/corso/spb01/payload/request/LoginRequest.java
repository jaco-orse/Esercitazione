package it.corso.spb01.payload.request;

import lombok.Getter;
import lombok.Setter;

import jakarta.validation.constraints.NotBlank;

public class LoginRequest {
	@NotBlank
	@Setter
	@Getter
	private String username;

	@NotBlank
	@Getter
	@Setter

	private String password;
}
