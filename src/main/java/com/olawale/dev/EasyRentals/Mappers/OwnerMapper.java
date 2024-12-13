package com.olawale.dev.EasyRentals.Mappers;

import com.olawale.dev.EasyRentals.Dtos.OwnerDto;
import com.olawale.dev.EasyRentals.Entities.Owner;
import com.olawale.dev.EasyRentals.Entities.Property;

import java.util.List;
import java.util.stream.Collectors;

public class OwnerMapper {

    // Map Owner entity to OwnerDto
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
                .properties(owner.getProperties() != null
                        ? owner.getProperties().stream()
                        .map(PropertyMapper::mapToPropertyDto) // Map each property to PropertyDto
                        .collect(Collectors.toList())
                        : List.of())
                .build();
    }

    // Map OwnerDto to Owner entity
    public static Owner mapToOwner(OwnerDto ownerDto) {
        if (ownerDto == null) {
            return null;
        }

        List<Property> properties = ownerDto.getProperties() != null
                ? ownerDto.getProperties().stream()
                .map(PropertyMapper::mapToProperty) // Map each PropertyDto to Property
                .collect(Collectors.toList())
                : List.of();

        return Owner.builder()
                .id(ownerDto.getId())
                .firstName(ownerDto.getFirstName())
                .lastName(ownerDto.getLastName())
                .email(ownerDto.getEmail())
                .password(ownerDto.getPassword())
//                .password(passwordEncoder.encode(ownerDto.getPassword())) // Encode password
                .role(ownerDto.getRole())
                .properties(properties) // Map to properties list
                .build();
    }



}
