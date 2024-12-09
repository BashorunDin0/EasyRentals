package com.olawale.dev.EasyRentals.Mappers;

import com.olawale.dev.EasyRentals.Dtos.TenantDto;
import com.olawale.dev.EasyRentals.Entities.Tenant;

public class TenantMapper {
    public static TenantDto mapToTenantDto(Tenant tenant){
        return new TenantDto(
                tenant.getId(),
                tenant.getFirstName(),
                tenant.getLastName(),
                tenant.getEmail(),
                tenant.getPhoneNumber(),
                tenant.getAddress()
        );
    }
    public static Tenant mapToTenant(TenantDto tenantDto){
        return new Tenant(
                tenantDto.getId(),
                tenantDto.getFirstName(),
                tenantDto.getLastName(),
                tenantDto.getEmail(),
                tenantDto.getPhoneNumber(),
                tenantDto.getAddress()
        );
    }
}
