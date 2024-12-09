package com.olawale.dev.EasyRentals.Dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor

public class TenantDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String address;
    private String role = "TENANT";
    private String phoneNumber;
    private String email;

    public TenantDto(Long id, @NotBlank(message = "First name is mandatory") @Size(max = 50, message = "First name must not exceed 50 characters ") String firstName, @NotBlank(message = "Last name is mandatory") @Size(max = 50, message = "Last name must not exceed 50 characters ") String lastName, @NotBlank(message = "Email is mandatory") @Email(message = "Email must be valid") String email, @Pattern(regexp = "\\d{10,15}", message = "Phone number must be valid and contain 10-15 digits") String phoneNumber, @Size(max = 100, message = "Address must not exceed 100 characters") String address) {
    }
}
