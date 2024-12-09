package com.olawale.dev.EasyRentals.Services;

import com.olawale.dev.EasyRentals.Dtos.PropertyDto;

import java.util.List;

public interface PropertyService {
    PropertyDto addProperty(PropertyDto propertyDto);
    PropertyDto getPropertyById(Long propertyId);
    List<PropertyDto> getAllProperties();
    PropertyDto updateProperty(Long propertyId, PropertyDto propertyDto);
    void deleteProperty(Long propertyId);
    List<PropertyDto> searchProperties(String location, Double maxPrice, Integer rooms);
}
