package com.securetaskflow.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class SignupRequest {
	private String username;
	private String password;
	private String role; // Example: ROLE_USER or ROLE_ADMIN
}
