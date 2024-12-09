package com.olawale.dev.EasyRentals.Services;

import com.olawale.dev.EasyRentals.Dtos.PropertyPictureDto;
import com.olawale.dev.EasyRentals.Entities.Property;
import com.olawale.dev.EasyRentals.Entities.PropertyPicture;
import com.olawale.dev.EasyRentals.Mappers.PropertyPictureMapper;
import com.olawale.dev.EasyRentals.Repositories.PropertyPictureRepository;
import com.olawale.dev.EasyRentals.Repositories.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PropertyPictureServiceImpl implements PropertyPictureService {

    private final PropertyPictureRepository propertyPictureRepository;
    private final PropertyRepository propertyRepository;
    private final PropertyPictureMapper propertyPictureMapper;

    @Autowired
    public PropertyPictureServiceImpl(PropertyPictureRepository propertyPictureRepository,
                                      PropertyRepository propertyRepository,
                                      PropertyPictureMapper propertyPictureMapper) {
        this.propertyPictureRepository = propertyPictureRepository;
        this.propertyRepository = propertyRepository;
        this.propertyPictureMapper = propertyPictureMapper;
    }

    @Override
    public PropertyPictureDto addPropertyPicture(PropertyPictureDto propertyPictureDto, Long propertyId) {
        Property property = propertyRepository.findById(propertyId)
                .orElseThrow(() -> new RuntimeException("Property not found with id " + propertyId));

        PropertyPicture propertyPicture = propertyPictureMapper.toEntity(propertyPictureDto, property);
        PropertyPicture savedPropertyPicture = propertyPictureRepository.save(propertyPicture);

        return propertyPictureMapper.toDto(savedPropertyPicture);
    }

    @Override
    public PropertyPictureDto updatePropertyPicture(Long pictureId, PropertyPictureDto propertyPictureDto) {
        PropertyPicture propertyPicture = propertyPictureRepository.findById(pictureId)
                .orElseThrow(() -> new RuntimeException("Property picture not found with id " + pictureId));

        propertyPicture.setUrl(propertyPictureDto.getUrl());
        propertyPicture.setProperty(propertyRepository.findById(propertyPictureDto.getPropertyId())
                .orElseThrow(() -> new RuntimeException("Property not found with id " + propertyPictureDto.getPropertyId())));

        PropertyPicture updatedPropertyPicture = propertyPictureRepository.save(propertyPicture);

        return propertyPictureMapper.toDto(updatedPropertyPicture);
    }

    @Override
    public void deletePropertyPicture(Long pictureId) {
        PropertyPicture propertyPicture = propertyPictureRepository.findById(pictureId)
                .orElseThrow(() -> new RuntimeException("Property picture not found with id " + pictureId));

        propertyPictureRepository.delete(propertyPicture);
    }

    @Override
    public List<PropertyPictureDto> getPropertyPictures(Long propertyId) {
        List<PropertyPicture> propertyPictures = propertyPictureRepository.findByPropertyId(propertyId);

        return propertyPictures.stream()
                .map(propertyPictureMapper::toDto)
                .collect(Collectors.toList());
    }
}
