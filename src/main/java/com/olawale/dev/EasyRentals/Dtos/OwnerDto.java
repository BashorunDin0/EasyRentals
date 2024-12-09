package com.olawale.dev.EasyRentals.Dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OwnerDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String role = "OWNER";
    private List<Long> propertyId;

    public OwnerDto(Long id, @NotBlank(message = "First name is mandatory") @Size(max = 50, message = "First name must not exceed 50 characters ") String firstName, @NotBlank(message = "Last name is mandatory") @Size(max = 50, message = "Last name must not exceed 50 characters ") String lastName, @NotBlank(message = "Email is mandatory") @Email(message = "Email must be valid") String email, Object o) {
    }
}
