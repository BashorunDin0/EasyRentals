package com.olawale.dev.EasyRentals.Mappers;

import com.olawale.dev.EasyRentals.Dtos.AdminDto;
import com.olawale.dev.EasyRentals.Entities.Admin;

public class AdminMapper {
    public static AdminDto mapToAdminDto(Admin admin){
        return new AdminDto(
                admin.getId(),
                admin.getRole(),
                admin.getEmail(),
                admin.getUsername(),
                admin.getCreatedAt(),
                admin.getUpdatedAt()
        );
    }

    public static Admin mapToAdmin(AdminDto adminDto){
        return new Admin(
                adminDto.getId(),
                adminDto.getRole(),
                adminDto.getEmail(),
                adminDto.getUsername(),
                adminDto.getCreatedAt(),
                adminDto.getUpdatedAt()
        );
    }
}
