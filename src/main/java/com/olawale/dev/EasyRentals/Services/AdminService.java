package com.olawale.dev.EasyRentals.Services;

import com.olawale.dev.EasyRentals.Dtos.OwnerDto;
import com.olawale.dev.EasyRentals.Dtos.PropertyDto;
import com.olawale.dev.EasyRentals.Dtos.TenantDto;

import java.util.List;

public interface AdminService {
    void deleteTenant(Long tenantId);
    void deleteProperty(Long propertyId);
    void deleteOwner(Long ownerId);

    List<TenantDto> getAllTenants();
    List<OwnerDto> getAllOwners();
    List<PropertyDto> getAllProperties();
    TenantDto getTenantById(Long tenantId);
    OwnerDto getOwnerById(Long ownerId);
    PropertyDto getPropertyById(Long propertyId);

    TenantDto updateTenant(Long tenantId, TenantDto tenantDetails);
    OwnerDto updateOwner(Long ownerId, OwnerDto ownerDetails);
    PropertyDto updateProperty(Long propertyId, PropertyDto propertyDetails);
}
