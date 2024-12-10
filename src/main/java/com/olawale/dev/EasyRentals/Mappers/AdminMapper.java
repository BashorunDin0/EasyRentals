package com.olawale.dev.EasyRentals.Mappers;

import com.olawale.dev.EasyRentals.Dtos.AdminDto;
import com.olawale.dev.EasyRentals.Entities.Admin;

public class AdminMapper {
    public static AdminDto mapToAdminDto(Admin admin){
        return AdminDto.builder()
                .id(admin.getId())
                .username(admin.getUsername())
                .role(admin.getRole())
                .email(admin.getEmail())
                .createdAt(admin.getCreatedAt())
                .updatedAt(admin.getUpdatedAt())
                .build();

    }

    public static Admin mapToAdmin(AdminDto adminDto){
        return Admin.builder()
                .id(adminDto.getId())
                .username(adminDto.getUsername())
                .role(adminDto.getRole())
                .email(adminDto.getEmail())
                .createdAt(adminDto.getCreatedAt())
                .updatedAt(adminDto.getUpdatedAt())
                .build();

    }
}
