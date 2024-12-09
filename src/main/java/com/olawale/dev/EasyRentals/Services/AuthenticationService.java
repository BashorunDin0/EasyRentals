package com.olawale.dev.EasyRentals.Services;

import com.olawale.dev.EasyRentals.Entities.LoginRequest;
import com.olawale.dev.EasyRentals.Entities.RegisterRequest;
import com.olawale.dev.EasyRentals.Entities.Role;
import com.olawale.dev.EasyRentals.Entities.User;
import com.olawale.dev.EasyRentals.Exceptions.InvalidCredentialsException;
import com.olawale.dev.EasyRentals.Exceptions.UserNotFoundException;
import com.olawale.dev.EasyRentals.Repositories.UserRepository;
import com.olawale.dev.EasyRentals.Utils.JwtUtil;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class AuthenticationService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;

    // Constructor injection
    public AuthenticationService(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtUtil jwtUtils) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtils;
    }

    // Authenticate user and return JWT
    public String authenticate(LoginRequest loginRequest) throws InvalidCredentialsException {
        // Find user by username
        User user = userRepository.findByUsername(loginRequest.getUsername())
                .orElseThrow(() -> new UserNotFoundException("User not found with username: " + loginRequest.getUsername()));

        // Validate password
        if (!passwordEncoder.matches(loginRequest.getPassword(), user.getPassword())) {
            throw new InvalidCredentialsException("Invalid credentials");
        }

        // Generate and return the JWT token
        Collection<? extends GrantedAuthority> authorities = user.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.name())) // or role.getName() for Role class
                .collect(Collectors.toList());

        UserDetails userDetails = new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                authorities// Assuming the roles are properly set up
        );

        return jwtUtil.generateToken(userDetails);  // Use UserDetails for JWT generation
    }

    // Register new user
    public void register(RegisterRequest registerRequest) {
        // Check if the username already exists
        if (userRepository.findByUsername(registerRequest.getUsername()).isPresent()) {
            throw new RuntimeException("Username is already taken");
        }

        // Create a new user and set properties
        User newUser = new User();
        newUser.setUsername(registerRequest.getUsername());
        newUser.setPassword(passwordEncoder.encode(registerRequest.getPassword())); // Encrypt password
        newUser.setEmail(registerRequest.getEmail());

        // Optionally set default roles
        newUser.setRoles(Set.of(Role.valueOf("USER")));  // Example: Assigning default role to user

        // Save user to the database
        userRepository.save(newUser);
    }
}
