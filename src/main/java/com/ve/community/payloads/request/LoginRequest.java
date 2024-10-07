package com.ve.community.payloads.request;

import jakarta.validation.constraints.NotBlank;

public class LoginRequest {
	public @NotBlank String getEmail() {
		return email;
	}

	public void setEmail(@NotBlank String email) {
		this.email = email;
	}

	@NotBlank
	private String email;

	@NotBlank
	private String password;



	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
