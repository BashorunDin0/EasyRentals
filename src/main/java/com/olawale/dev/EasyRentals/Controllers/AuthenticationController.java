package com.olawale.dev.EasyRentals.Controllers;

import com.olawale.dev.EasyRentals.Entities.LoginRequest;
import com.olawale.dev.EasyRentals.Entities.RegisterRequest;
import com.olawale.dev.EasyRentals.Exceptions.InvalidCredentialsException;
import com.olawale.dev.EasyRentals.Services.AuthenticationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    // Login Endpoint
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) throws InvalidCredentialsException {
        String token = authenticationService.authenticate(loginRequest);
        return ResponseEntity.ok(token);  // Return the JWT token to the client
    }

    // Registration Endpoint
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterRequest registerRequest) {
        authenticationService.register(registerRequest);
        return ResponseEntity.ok("User registered successfully!");
    }
}