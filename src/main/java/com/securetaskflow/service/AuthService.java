package com.securetaskflow.service;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.security.core.Authentication;

import com.securetaskflow.dto.AuthRequest;
import com.securetaskflow.dto.LoginRequest;
import com.securetaskflow.dto.RegisterRequest;
import com.securetaskflow.dto.SignupRequest;
import com.securetaskflow.entity.User;
import com.securetaskflow.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService {

	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;
	private final AuthenticationManager authenticationManager;

	public String register(SignupRequest request) {
		if (userRepository.existsByUsername(request.getUsername())) {
			return "Username already exists!";
		}

		User user = new User();
		user.setUsername(request.getUsername());
		user.setPassword(passwordEncoder.encode(request.getPassword()));
		user.setRole(request.getRole()); // e.g., "ROLE_USER", "ROLE_ADMIN"
		userRepository.save(user);

		return "User registered successfully!";
	}

	// Login user and verify credentials
	public String login(LoginRequest request) {
		System.out.println("Logging in user: " + request.getUsername());
		System.out.println("Encoded Password from DB: " + userRepository.findByUsername(request.getUsername()).get().getPassword());

		// Spring Security handles the credential validation internally here
		authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
		return "User logged in successfully!";
		
	}
}