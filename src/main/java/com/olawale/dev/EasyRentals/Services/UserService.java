package com.olawale.dev.EasyRentals.Services;

import com.olawale.dev.EasyRentals.Dtos.UserDto;
import com.olawale.dev.EasyRentals.Entities.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
    User registerUser(UserDto userDto);

    User getUserById(Long id);

    List<User> getAllUsers();

    User getCurrentUser();

    void updateUser(Long id, UserDto userDto);

    void deleteUser(Long id);

}
