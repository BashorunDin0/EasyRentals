package com.olawale.dev.EasyRentals.Services;

import com.olawale.dev.EasyRentals.Dtos.OwnerDto;
import com.olawale.dev.EasyRentals.Dtos.PropertyDto;
import com.olawale.dev.EasyRentals.Dtos.TenantDto;
import com.olawale.dev.EasyRentals.Entities.Owner;
import com.olawale.dev.EasyRentals.Entities.Property;
import com.olawale.dev.EasyRentals.Entities.Tenant;
import com.olawale.dev.EasyRentals.Exceptions.ResourceNotFoundException;
import com.olawale.dev.EasyRentals.Mappers.OwnerMapper;
import com.olawale.dev.EasyRentals.Mappers.PropertyMapper;
import com.olawale.dev.EasyRentals.Mappers.TenantMapper;
import com.olawale.dev.EasyRentals.Repositories.OwnerRepository;
import com.olawale.dev.EasyRentals.Repositories.PropertyRepository;
import com.olawale.dev.EasyRentals.Repositories.TenantRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdminServiceImpl implements AdminService{

    private final TenantRepository tenantRepository;
    private final OwnerRepository ownerRepository;
    private final PropertyRepository propertyRepository;

    public AdminServiceImpl(TenantRepository tenantRepository, OwnerRepository ownerRepository, PropertyRepository propertyRepository) {
        this.tenantRepository = tenantRepository;
        this.ownerRepository = ownerRepository;
        this.propertyRepository = propertyRepository;
    }

    @Override
    public void deleteTenant(Long tenantId) {
        Tenant tenant = tenantRepository.findById(tenantId)
                .orElseThrow(() -> new ResourceNotFoundException("Tenant not found with ID: " + tenantId));
        tenantRepository.delete(tenant);
    }

    @Override
    public void deleteProperty(Long propertyId) {
        Property property = propertyRepository.findById(propertyId)
                .orElseThrow(() -> new ResourceNotFoundException("Property not found with ID: " + propertyId));
        propertyRepository.delete(property);
    }

    @Override
    public void deleteOwner(Long ownerId) {
        Owner owner = ownerRepository.findById(ownerId)
                .orElseThrow(() -> new ResourceNotFoundException("Owner not found with ID: " + ownerId));
        ownerRepository.delete(owner);
    }

    @Override
    public List<TenantDto> getAllTenants() {
        return tenantRepository.findAll()
                .stream()
                .map(TenantMapper::mapToTenantDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<OwnerDto> getAllOwners() {
        return ownerRepository.findAll()
                .stream()
                .map(OwnerMapper::mapToOwnerDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<PropertyDto> getAllProperties() {
        return propertyRepository.findAll()
                .stream()
                .map(PropertyMapper::mapToPropertyDto)
                .collect(Collectors.toList());
    }

    @Override
    public TenantDto getTenantById(Long tenantId) {
        Tenant tenant = tenantRepository.findById(tenantId)
                .orElseThrow(() -> new ResourceNotFoundException("Tenant not found with ID: " + tenantId));
        return TenantMapper.mapToTenantDto(tenant);
    }

    @Override
    public OwnerDto getOwnerById(Long ownerId) {
        Owner owner = ownerRepository.findById(ownerId)
                .orElseThrow(() -> new ResourceNotFoundException("Owner not found with ID: " + ownerId));
        return OwnerMapper.mapToOwnerDto(owner);
    }

    @Override
    public PropertyDto getPropertyById(Long propertyId) {
        Property property = propertyRepository.findById(propertyId)
                .orElseThrow(() -> new ResourceNotFoundException("Property not found with ID: " + propertyId));
        return PropertyMapper.mapToPropertyDto(property);
    }

    @Override
    public TenantDto updateTenant(Long tenantId, TenantDto tenantDetails) {
        Tenant tenant = tenantRepository.findById(tenantId)
                .orElseThrow(() -> new ResourceNotFoundException("Tenant not found with ID: " + tenantId));

        tenant.setFirstName(tenantDetails.getFirstName());
        tenant.setLastName(tenantDetails.getLastName());
        tenant.setEmail(tenantDetails.getEmail());
        tenant.setPhoneNumber(tenantDetails.getPhoneNumber());
        Tenant updatedTenant = tenantRepository.save(tenant);
        return TenantMapper.mapToTenantDto(updatedTenant);
    }

    @Override
    public OwnerDto updateOwner(Long ownerId, OwnerDto ownerDetails) {
        Owner owner = ownerRepository.findById(ownerId)
                .orElseThrow(() -> new ResourceNotFoundException("Owner not found with ID: " + ownerId));

        owner.setFirstName(ownerDetails.getFirstName());
        owner.setLastName(ownerDetails.getLastName());
        owner.setEmail(ownerDetails.getEmail());
        Owner updatedOwner = ownerRepository.save(owner);
        return OwnerMapper.mapToOwnerDto(updatedOwner);
    }

    @Override
    public PropertyDto updateProperty(Long propertyId, PropertyDto propertyDetails) {
        Property property = propertyRepository.findById(propertyId)
                .orElseThrow(() -> new ResourceNotFoundException("Property not found with ID: " + propertyId));

        property.setId(propertyDetails.getId());
        property.setAddress(propertyDetails.getAddress());
        property.setRent(propertyDetails.getRent());
        Property updatedProperty = propertyRepository.save(property);
        return PropertyMapper.mapToPropertyDto(updatedProperty);
    }
}
