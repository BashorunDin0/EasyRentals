package com.olawale.dev.EasyRentals.Dtos;


import com.olawale.dev.EasyRentals.Entities.Role;
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
    private Role role;
    private String password;
    private String phoneNumber;
    private String email;

}
