package com.olawale.dev.EasyRentals.Services;

import com.olawale.dev.EasyRentals.Dtos.PropertyDto;
import com.olawale.dev.EasyRentals.Dtos.TenantDto;

import java.util.List;

public interface TenantService {
    TenantDto registerTenant(TenantDto tenantDto);
    TenantDto getTenantById(Long tenantId);
    List<PropertyDto> getAllProperties();
    List<PropertyDto> searchProperties(String location, Double maxPrice, Integer rooms);
    TenantDto updateTenant(Long tenantId, TenantDto tenantDto);
}