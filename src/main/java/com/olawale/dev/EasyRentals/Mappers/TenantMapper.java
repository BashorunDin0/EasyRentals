package com.olawale.dev.EasyRentals.Mappers;

import com.olawale.dev.EasyRentals.Dtos.TenantDto;
import com.olawale.dev.EasyRentals.Entities.Tenant;

public class TenantMapper {
    public static TenantDto mapToTenantDto(Tenant tenant){
        return TenantDto.builder()
                .id(tenant.getId())
                .firstName(tenant.getFirstName())
                .lastName(tenant.getLastName())
                .email(tenant.getEmail())
                .phoneNumber(tenant.getPhoneNumber())
                .address(tenant.getAddress())
                .build();

    }
    public static Tenant mapToTenant(TenantDto tenantDto){
        return Tenant.builder()
                .id(tenantDto.getId())
                .firstName(tenantDto.getFirstName())
                .lastName(tenantDto.getLastName())
                .email(tenantDto.getEmail())
                .phoneNumber(tenantDto.getPhoneNumber())
                .address(tenantDto.getAddress())
                .build();

    }
}
