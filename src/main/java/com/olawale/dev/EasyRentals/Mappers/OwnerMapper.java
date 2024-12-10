package com.olawale.dev.EasyRentals.Mappers;

import com.olawale.dev.EasyRentals.Dtos.OwnerDto;
import com.olawale.dev.EasyRentals.Entities.Owner;
import com.olawale.dev.EasyRentals.Entities.Property;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;
import java.util.stream.Collectors;


public class OwnerMapper {
    @Autowired
    private static PasswordEncoder passwordEncoder;

    public static OwnerDto mapToOwnerDto(Owner owner) {
        if (owner == null) {
            return null;
        }

        return OwnerDto.builder()
                .id(owner.getId())
                .firstName(owner.getFirstName())
                .lastName(owner.getLastName())
                .email(owner.getEmail())
                .role(owner.getRole())
                .propertyId(owner.getProperties() != null ? owner.getProperties().stream()
                        .map(Property::getId).collect(Collectors.toList()): List.of())
                .build();

    }

    public static Owner mapToOwner(OwnerDto ownerDto, List<Property> properties) {
        if (ownerDto == null) {
            return null;
        }

        return Owner.builder()
                .id(ownerDto.getId())
                .firstName(ownerDto.getFirstName())
                .lastName(ownerDto.getLastName())
                .email(ownerDto.getEmail())
                .role(ownerDto.getRole())
                .password(passwordEncoder.encode(ownerDto.getPassword())) // Set a default or replace with an actual password field from OwnerDto
                .properties(properties != null ? properties : List.of()) // Ensure properties is non-null
                .build();
    }
}
