package com.olawale.dev.EasyRentals.Services;

import com.olawale.dev.EasyRentals.Dtos.OwnerDto;
import com.olawale.dev.EasyRentals.Entities.Property;

import java.util.List;

public interface OwnerService {
    OwnerDto registerOwner(OwnerDto owner);
    List<OwnerDto> getAllOwner();
    List<Property> listProperties(Long ownerId);
    void deleteOwner(Long id);
    OwnerDto getOwnerById(Long id);
    OwnerDto updateOwner(Long id, OwnerDto ownerDetails);
}
