package com.olawale.dev.EasyRentals.Mappers;

import com.olawale.dev.EasyRentals.Dtos.OwnerDto;
import com.olawale.dev.EasyRentals.Entities.Owner;
import com.olawale.dev.EasyRentals.Entities.Property;

import java.util.List;
import java.util.stream.Collectors;


public class OwnerMapper {

    public static OwnerDto mapToOwnerDto(Owner owner) {
        if (owner == null) {
            return null;
        }

        return new OwnerDto(
                owner.getId(),
                owner.getFirstName(),
                owner.getLastName(),
                owner.getEmail(),
                owner.getProperties() != null
                        ? owner.getProperties().stream()
                        .map(Property::getId)
                        .collect(Collectors.toList())
                        : List.of() // Returns an empty list if properties are null
        );
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
                .password("defaultPassword") // Set a default or replace with an actual password field from OwnerDto
                .properties(properties != null ? properties : List.of()) // Ensure properties is non-null
                .build();
    }
}
