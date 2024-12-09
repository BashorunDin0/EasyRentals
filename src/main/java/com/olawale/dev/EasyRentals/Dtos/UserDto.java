package com.olawale.dev.EasyRentals.Dtos;

import com.olawale.dev.EasyRentals.Entities.Role;
import lombok.Data;

import java.util.Set;

@Data
public class UserDto {
    private String username;
    private String email;
    private String password;
    private Set<Role> roles;
}
