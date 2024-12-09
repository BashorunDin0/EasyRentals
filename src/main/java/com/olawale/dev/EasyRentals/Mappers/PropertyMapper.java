package com.olawale.dev.EasyRentals.Mappers;

import com.olawale.dev.EasyRentals.Dtos.PropertyDto;
import com.olawale.dev.EasyRentals.Entities.Property;

public class PropertyMapper {

    public static PropertyDto mapToPropertyDto(Property property) {
        if (property == null) {
            return null;
        }

        return PropertyDto.builder()
                .id(property.getId())
                .address(property.getAddress())
                .rent(property.getRent())
                .numberOfRooms(property.getNumberOfRooms())
                .gated(property.getGatedStatus())
                .prepaid(property.getBillStatus())
                .isAvailable(property.getIsAvailable())
                .newlyConstructed(property.getNewlyConstructed())
                .build();
    }

    public static Property mapToProperty(PropertyDto propertyDto) {
        if (propertyDto == null) {
            return null;
        }

        return Property.builder()
                .id(propertyDto.getId())
                .address(propertyDto.getAddress())
                .rent(propertyDto.getRent())
                .numberOfRooms(propertyDto.getNumberOfRooms())
                .gatedStatus(propertyDto.getGated())
                .isAvailable(propertyDto.getIsAvailable())
                .newlyConstructed(propertyDto.getNewlyConstructed())
                .build();
    }
}
