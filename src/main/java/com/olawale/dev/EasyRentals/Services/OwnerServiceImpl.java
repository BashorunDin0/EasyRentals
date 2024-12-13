package com.olawale.dev.EasyRentals.Services;

import com.olawale.dev.EasyRentals.Dtos.OwnerDto;
import com.olawale.dev.EasyRentals.Entities.Owner;
import com.olawale.dev.EasyRentals.Entities.Property;
import com.olawale.dev.EasyRentals.Exceptions.ResourceNotFoundException;
import com.olawale.dev.EasyRentals.Mappers.OwnerMapper;
import com.olawale.dev.EasyRentals.Repositories.OwnerRepository;
import com.olawale.dev.EasyRentals.Repositories.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OwnerServiceImpl implements OwnerService {

    private final OwnerRepository ownerRepository;

    @Autowired
    public OwnerServiceImpl(OwnerRepository ownerRepository, PropertyRepository propertyRepository) {
        this.ownerRepository = ownerRepository;
    }

    @Override
    public OwnerDto registerOwner(OwnerDto ownerDto) {
        Owner owner = OwnerMapper.mapToOwner(ownerDto, new ArrayList<>());
        Owner savedOwner = ownerRepository.save(owner);
        return OwnerMapper.mapToOwnerDto(savedOwner);
    }

    @Override
    public List<OwnerDto> getAllOwner() {
        return ownerRepository.findAll().stream()
                .map(OwnerMapper::mapToOwnerDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<Property> listProperties(Long ownerId) {
        Owner owner = ownerRepository.findById(ownerId)
                .orElseThrow(() -> new ResourceNotFoundException("Owner not found with id: " + ownerId));
        return owner.getProperties();
    }

    @Override
    public void deleteOwner(Long id) {
        if (!ownerRepository.existsById(id)) {
            throw new ResourceNotFoundException("Owner not found with id: " + id);
        }
        ownerRepository.deleteById(id);
    }

    @Override
    public OwnerDto getOwnerById(Long id) {
        Owner owner = ownerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Owner not found with id: " + id));

        return OwnerMapper.mapToOwnerDto(owner);
    }

    @Override
    public OwnerDto updateOwner(Long id, OwnerDto ownerDetails) {
        Owner owner = ownerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Owner not found with id: " + id));

        // Update owner details
        owner.setFirstName(ownerDetails.getFirstName());
        owner.setLastName(ownerDetails.getLastName());
        owner.setEmail(ownerDetails.getEmail());

        Owner updatedOwner = ownerRepository.save(owner);

        return OwnerMapper.mapToOwnerDto(updatedOwner);
    }
}