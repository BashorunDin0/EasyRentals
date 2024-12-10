package com.olawale.dev.EasyRentals.Entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

@Builder
@Entity
@Data
public class Tenant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    @NotBlank(message = "First name is mandatory")
    @Size(max = 50, message = "First name must not exceed 50 characters ")
    private String firstName;
    @Column(nullable = false)
    @NotBlank(message = "Last name is mandatory")
    @Size(max = 50, message = "Last name must not exceed 50 characters ")
    private String lastName;
    @Size(max = 100, message = "Address must not exceed 100 characters")
    private String address;
    @Column(nullable = false)
    @Pattern(regexp = "\\d{10,15}", message = "Phone number must be valid and contain 10-15 digits")
    private String phoneNumber;
    @Column(unique = true)
    @NotBlank(message = "Email is mandatory")
    @Email(message = "Email must be valid")
    private String email;
    @Enumerated(EnumType.STRING)
    private Role role = Role.TENANT;
    @Column(nullable = false)
    @NotBlank(message = "Password is mandatory")
    @Size(min = 8, message = "Password must be at least 8 characters long ")
    private String password;

}
