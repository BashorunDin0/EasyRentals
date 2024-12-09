package com.olawale.dev.EasyRentals.Mappers;

import com.olawale.dev.EasyRentals.Dtos.PropertyPictureDto;
import com.olawale.dev.EasyRentals.Entities.Property;
import com.olawale.dev.EasyRentals.Entities.PropertyPicture;
import org.springframework.stereotype.Component;

@Component
public class PropertyPictureMapper {

    public PropertyPictureDto toDto(PropertyPicture propertyPicture) {
        PropertyPictureDto dto = new PropertyPictureDto();
        dto.setId(propertyPicture.getId());
        dto.setUrl(propertyPicture.getUrl());
        dto.setPropertyId(propertyPicture.getProperty().getId());  // Correct way to access propertyId
        return dto;
    }

    public PropertyPicture toEntity(PropertyPictureDto dto, Property property) {
        PropertyPicture propertyPicture = new PropertyPicture();
        propertyPicture.setId(dto.getId());
        propertyPicture.setUrl(dto.getUrl());
        propertyPicture.setProperty(property); // Setting the property entity
        return propertyPicture;
    }
}
