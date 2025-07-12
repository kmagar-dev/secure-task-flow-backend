package com.securetaskflow.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.securetaskflow.dto.LoginRequest;
import com.securetaskflow.dto.RegisterRequest;
import com.securetaskflow.dto.SignupRequest;
import com.securetaskflow.service.AuthService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

	private final AuthService authService;

	@PostMapping("/signup")
	public ResponseEntity<String> registerUser(@RequestBody SignupRequest request) {
		authService.register(request);
		return ResponseEntity.ok("User registered successfully!");
	}

	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody LoginRequest request) {
		String response = authService.login(request);
		return ResponseEntity.ok(response);
	}
}
