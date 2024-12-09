package com.olawale.dev.EasyRentals.Services;

import com.olawale.dev.EasyRentals.Dtos.PropertyDto;
import com.olawale.dev.EasyRentals.Entities.Property;
import com.olawale.dev.EasyRentals.Exceptions.ResourceNotFoundException;
import com.olawale.dev.EasyRentals.Mappers.PropertyMapper;
import com.olawale.dev.EasyRentals.Repositories.PropertyRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PropertyServiceImpl implements PropertyService {
    private final PropertyRepository propertyRepository;

    @Override
    public PropertyDto addProperty(PropertyDto propertyDto) {
        Property property = PropertyMapper.mapToProperty(propertyDto);
        Property savedProperty = propertyRepository.save(property);
        return PropertyMapper.mapToPropertyDto(savedProperty);
    }

    @Override
    public PropertyDto getPropertyById(Long propertyId) {
        Property property = propertyRepository.findById(propertyId)
                .orElseThrow(() -> new ResourceNotFoundException("Property not found with ID: " + propertyId));
        return PropertyMapper.mapToPropertyDto(property);
    }

    @Override
    public List<PropertyDto> getAllProperties() {
        List<Property> properties = propertyRepository.findAll();
        return properties.stream()
                .map(PropertyMapper::mapToPropertyDto)
                .collect(Collectors.toList());
    }

    @Override
    public PropertyDto updateProperty(Long propertyId, PropertyDto propertyDto) {
        Property property = propertyRepository.findById(propertyId)
                .orElseThrow(() -> new ResourceNotFoundException("Property not found with ID: " + propertyId));

        property.setAddress(propertyDto.getAddress());
        property.setRent(propertyDto.getRent());
        property.setNumberOfRooms(propertyDto.getNumberOfRooms());
        property.setGatedStatus(propertyDto.getGated());
        property.setIsAvailable(propertyDto.getIsAvailable());
        property.setNewlyConstructed(propertyDto.getNewlyConstructed());

        Property updatedProperty = propertyRepository.save(property);
        return PropertyMapper.mapToPropertyDto(updatedProperty);
    }

    @Override
    public void deleteProperty(Long propertyId) {
        Property property = propertyRepository.findById(propertyId)
                .orElseThrow(() -> new ResourceNotFoundException("Property not found with ID: " + propertyId));
        propertyRepository.delete(property);
    }

    @Override
    public List<PropertyDto> searchProperties(String location, Double maxPrice, Integer rooms) {
        // Custom query for searching properties based on multiple criteria
        List<Property> properties = propertyRepository.findByAddressContainingAndRentLessThanEqualAndNumberOfRooms(location, maxPrice, rooms);
        return properties.stream()
                .map(PropertyMapper::mapToPropertyDto)
                .collect(Collectors.toList());
    }

}
