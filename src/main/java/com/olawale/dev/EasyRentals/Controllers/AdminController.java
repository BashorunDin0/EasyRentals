package com.olawale.dev.EasyRentals.Controllers;

import com.olawale.dev.EasyRentals.Dtos.OwnerDto;
import com.olawale.dev.EasyRentals.Dtos.PropertyDto;
import com.olawale.dev.EasyRentals.Dtos.TenantDto;
import com.olawale.dev.EasyRentals.Services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admins")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping("/tenants")
    public ResponseEntity<List<TenantDto>> getAllTenants() {
        List<TenantDto> tenants = adminService.getAllTenants();
        return ResponseEntity.ok(tenants);
    }

    @GetMapping("/tenants/{tenantId}")
    public ResponseEntity<TenantDto> getTenantById(@PathVariable Long tenantId) {
        TenantDto tenant = adminService.getTenantById(tenantId);
        return ResponseEntity.ok(tenant);
    }

    @PutMapping("/tenants/{tenantId}")
    public ResponseEntity<TenantDto> updateTenant(@PathVariable Long tenantId, @RequestBody TenantDto tenantDetails) {
        TenantDto updatedTenant = adminService.updateTenant(tenantId, tenantDetails);
        return ResponseEntity.ok(updatedTenant);
    }

    @DeleteMapping("/tenants/{tenantId}")
    public ResponseEntity<Void> deleteTenant(@PathVariable Long tenantId) {
        adminService.deleteTenant(tenantId);
        return ResponseEntity.noContent().build();
    }

    // Owner Endpoints

    @GetMapping("/owners")
    public ResponseEntity<List<OwnerDto>> getAllOwners() {
        List<OwnerDto> owners = adminService.getAllOwners();
        return ResponseEntity.ok(owners);
    }

    @GetMapping("/owners/{ownerId}")
    public ResponseEntity<OwnerDto> getOwnerById(@PathVariable Long ownerId) {
        OwnerDto owner = adminService.getOwnerById(ownerId);
        return ResponseEntity.ok(owner);
    }

    @PutMapping("/owners/{ownerId}")
    public ResponseEntity<OwnerDto> updateOwner(@PathVariable Long ownerId, @RequestBody OwnerDto ownerDetails) {
        OwnerDto updatedOwner = adminService.updateOwner(ownerId, ownerDetails);
        return ResponseEntity.ok(updatedOwner);
    }

    @DeleteMapping("/owners/{ownerId}")
    public ResponseEntity<Void> deleteOwner(@PathVariable Long ownerId) {
        adminService.deleteOwner(ownerId);
        return ResponseEntity.noContent().build();
    }

    // Property Endpoints

    @GetMapping("/properties")
    public ResponseEntity<List<PropertyDto>> getAllProperties() {
        List<PropertyDto> properties = adminService.getAllProperties();
        return ResponseEntity.ok(properties);
    }

    @GetMapping("/properties/{propertyId}")
    public ResponseEntity<PropertyDto> getPropertyById(@PathVariable Long propertyId) {
        PropertyDto property = adminService.getPropertyById(propertyId);
        return ResponseEntity.ok(property);
    }

    @PutMapping("/properties/{propertyId}")
    public ResponseEntity<PropertyDto> updateProperty(@PathVariable Long propertyId, @RequestBody PropertyDto propertyDetails) {
        PropertyDto updatedProperty = adminService.updateProperty(propertyId, propertyDetails);
        return ResponseEntity.ok(updatedProperty);
    }

    @DeleteMapping("/properties/{propertyId}")
    public ResponseEntity<Void> deleteProperty(@PathVariable Long propertyId) {
        adminService.deleteProperty(propertyId);
        return ResponseEntity.noContent().build();
    }

}
