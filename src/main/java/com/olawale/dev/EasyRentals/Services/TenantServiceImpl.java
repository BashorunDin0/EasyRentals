package com.olawale.dev.EasyRentals.Services;

import com.olawale.dev.EasyRentals.Dtos.PropertyDto;
import com.olawale.dev.EasyRentals.Dtos.TenantDto;
import com.olawale.dev.EasyRentals.Entities.Property;
import com.olawale.dev.EasyRentals.Entities.Tenant;
import com.olawale.dev.EasyRentals.Exceptions.ResourceNotFoundException;
import com.olawale.dev.EasyRentals.Mappers.PropertyMapper;
import com.olawale.dev.EasyRentals.Mappers.TenantMapper;
import com.olawale.dev.EasyRentals.Repositories.PropertyRepository;
import com.olawale.dev.EasyRentals.Repositories.TenantRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class TenantServiceImpl implements TenantService {
    private final TenantRepository tenantRepository;
    private final PropertyRepository propertyRepository;

    @Override
    public TenantDto registerTenant(TenantDto tenantDto) {
        Tenant tenant = TenantMapper.mapToTenant(tenantDto);
        Tenant savedTenant = tenantRepository.save(tenant);
        return TenantMapper.mapToTenantDto(savedTenant);
    }

    @Override
    public TenantDto getTenantById(Long tenantId) {
        Tenant tenant = tenantRepository.findById(tenantId)
                .orElseThrow(() -> new ResourceNotFoundException("Tenant not found with ID: " + tenantId));
        return TenantMapper.mapToTenantDto(tenant);
    }

    @Override
    public List<PropertyDto> getAllProperties() {
        List<Property> properties = propertyRepository.findAll();
        return properties.stream()
                .map(PropertyMapper::mapToPropertyDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<PropertyDto> searchProperties(String location, Double maxPrice, Integer rooms) {
        List<Property> properties = propertyRepository.findByAddressAndRentAndNumberOfRooms(location, maxPrice, rooms);
        return properties.stream()
                .map(PropertyMapper::mapToPropertyDto)
                .collect(Collectors.toList());
    }

    @Override
    public TenantDto updateTenant(Long tenantId, TenantDto tenantDto) {
        Tenant tenant = tenantRepository.findById(tenantId)
                .orElseThrow(() -> new ResourceNotFoundException("Tenant not found with ID: " + tenantId));

        tenant.setFirstName(tenantDto.getFirstName());
        tenant.setLastName(tenantDto.getLastName());
        tenant.setEmail(tenantDto.getEmail());
        tenant.setPhoneNumber(tenantDto.getPhoneNumber());
        tenant.setAddress(tenantDto.getAddress());

        Tenant updatedTenant = tenantRepository.save(tenant);
        return TenantMapper.mapToTenantDto(updatedTenant);
    }
}
