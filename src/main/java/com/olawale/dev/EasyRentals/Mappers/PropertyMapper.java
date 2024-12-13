package com.olawale.dev.EasyRentals.Mappers;

import com.olawale.dev.EasyRentals.Dtos.PropertyDto;
import com.olawale.dev.EasyRentals.Entities.Owner;
import com.olawale.dev.EasyRentals.Entities.Property;

public class PropertyMapper {

    // Map Property entity to PropertyDto
    public static PropertyDto mapToPropertyDto(Property property) {
        if (property == null) {
            return null;
        }

        return PropertyDto.builder()
                .id(property.getId())
                .address(property.getAddress())
                .rent(property.getRent())
                .numberOfRooms(property.getNumberOfRooms())
                .gated(property.getGated())
                .billStatus(property.getBillStatus())
                .pop(property.getPop())
                .ownerId(property.getOwner() != null ? property.getOwner().getId() : null) // Extract ownerId from Owner entity
                .isAvailable(property.getIsAvailable())
                .newlyConstructed(property.getNewlyConstructed())
                .build();
    }

    // Map PropertyDto to Property entity
    public static Property mapToProperty(PropertyDto propertyDto) {
        if (propertyDto == null) {
            return null;
        }

        // You may need to fetch the Owner entity based on the ownerId
        Owner owner = new Owner(); // Assuming you have a constructor or service to fetch owner by id
        owner.setId(propertyDto.getOwnerId());

        return Property.builder()
                .id(propertyDto.getId())
                .address(propertyDto.getAddress())
                .rent(propertyDto.getRent())
                .numberOfRooms(propertyDto.getNumberOfRooms())
                .gated(propertyDto.getGated())
                .billStatus(propertyDto.getBillStatus())
                .pop(propertyDto.getPop())
                .owner(owner)  // Set Owner entity based on the ownerId
                .isAvailable(propertyDto.getIsAvailable())
                .newlyConstructed(propertyDto.getNewlyConstructed())
                .build();
    }
}
