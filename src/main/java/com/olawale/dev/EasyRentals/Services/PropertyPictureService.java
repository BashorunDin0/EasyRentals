package com.olawale.dev.EasyRentals.Services;

import com.olawale.dev.EasyRentals.Dtos.PropertyPictureDto;

import java.util.List;

public interface PropertyPictureService {
    PropertyPictureDto addPropertyPicture(PropertyPictureDto propertyPictureDto, Long propertyId);
    PropertyPictureDto updatePropertyPicture(Long pictureId, PropertyPictureDto propertyPictureDto);
    void deletePropertyPicture(Long pictureId);
    List<PropertyPictureDto> getPropertyPictures(Long propertyId);
}
