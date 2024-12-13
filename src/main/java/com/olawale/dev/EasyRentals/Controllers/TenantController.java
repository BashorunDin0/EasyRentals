package com.olawale.dev.EasyRentals.Controllers;

import com.olawale.dev.EasyRentals.Dtos.PropertyDto;
import com.olawale.dev.EasyRentals.Dtos.TenantDto;
import com.olawale.dev.EasyRentals.Exceptions.ResourceNotFoundException;
import com.olawale.dev.EasyRentals.Services.TenantService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tenants")
public class TenantController {

    private final TenantService tenantService;

    public TenantController(TenantService tenantService) {
        this.tenantService = tenantService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerTenant(@RequestBody TenantDto tenantDto) {
        TenantDto registeredTenant = tenantService.registerTenant(tenantDto);
        String message = "Tenant with ID: " + registeredTenant.getId() + " was successfully registered.";
        return ResponseEntity.status(HttpStatus.CREATED).body(message);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TenantDto> getTenantById(@PathVariable Long id) {
        TenantDto tenantDto = tenantService.getTenantById(id);
        return ResponseEntity.ok(tenantDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateTenant(@PathVariable Long id, @RequestBody TenantDto tenantDto) {
        try {
            TenantDto updatedTenant = tenantService.updateTenant(id, tenantDto);
            String message = "Tenant with ID: " + id + " was successfully updated.";
            return ResponseEntity.ok(message);
        } catch (ResourceNotFoundException ex) {
            String errorMessage = "Tenant with ID: " + id + " cannot be updated because it does not exist.";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        }
    }

    @GetMapping("/properties")
    public ResponseEntity<List<PropertyDto>> getAllProperties() {
        List<PropertyDto> properties = tenantService.getAllProperties();
        return ResponseEntity.ok(properties);
    }

    @GetMapping("/properties/search")
    public ResponseEntity<List<PropertyDto>> searchProperties(
            @RequestParam(required = false) String address,
            @RequestParam(required = false) Double rent,
            @RequestParam(required = false) Integer numberOfRooms) {
        List<PropertyDto> properties = tenantService.searchProperties(address, rent, numberOfRooms);
        return ResponseEntity.ok(properties);
    }

}
