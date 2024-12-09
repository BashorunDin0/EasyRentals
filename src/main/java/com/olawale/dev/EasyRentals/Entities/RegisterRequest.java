package com.olawale.dev.EasyRentals.Entities;

import lombok.Data;

import java.util.Set;

@Data
public class RegisterRequest {
    private String username;
    private String password;
    private String email;
    private Set<Role> roles;
}
