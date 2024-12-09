package com.olawale.dev.EasyRentals.Dtos;

import com.olawale.dev.EasyRentals.Entities.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminDto {
    private Long id;
    private String username;
    private String email;
    private String role = "ADMIN";
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public AdminDto(Long id, Role role, @NotBlank(message = "Email is mandatory") @Email(message = "Email must be valid") String email, @NotBlank(message = "Username is mandatory") String username, LocalDateTime createdAt, LocalDateTime updatedAt) {
    }
}
