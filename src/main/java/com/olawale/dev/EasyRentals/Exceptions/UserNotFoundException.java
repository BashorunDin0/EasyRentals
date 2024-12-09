package com.olawale.dev.EasyRentals.Exceptions;

import jakarta.validation.constraints.NotBlank;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(@NotBlank(message = "Username is mandatory") @NotBlank(message = "Username is mandatory") String s) {
    }
}
