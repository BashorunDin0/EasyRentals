package com.olawale.dev.EasyRentals.Controllers;

import com.olawale.dev.EasyRentals.Dtos.OwnerDto;
import com.olawale.dev.EasyRentals.Entities.Property;
import com.olawale.dev.EasyRentals.Exceptions.ResourceNotFoundException;
import com.olawale.dev.EasyRentals.Services.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/owners")
public class OwnerController {

    @Autowired
    private OwnerService ownerService;

    @PostMapping("/registerOwner")
    public ResponseEntity<String> registerOwner(@RequestBody OwnerDto ownerDto) {
        try {
            OwnerDto createdOwner = ownerService.registerOwner(ownerDto);
            String message = "Owner with ID: " + createdOwner.getId()  + " was successfully registered.";
            return ResponseEntity.status(HttpStatus.CREATED).body(message);
        } catch (DataIntegrityViolationException ex) {
            String errorMessage = "Owner with ID or Email already exists.";
            return ResponseEntity.status(HttpStatus.CONFLICT).body(errorMessage);
        }
    }



    @GetMapping("/getAllOwners")
    public ResponseEntity<List<OwnerDto>> getAllOwners() {
        List<OwnerDto> owners = ownerService.getAllOwner();
        return ResponseEntity.ok(owners);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OwnerDto> getOwnerById(@PathVariable Long id) {
        OwnerDto owner = ownerService.getOwnerById(id);
        return ResponseEntity.ok(owner);
    }

    // Update an owner
    @PutMapping("/{id}")
    public ResponseEntity<String> updateOwner(@PathVariable Long id, @RequestBody OwnerDto ownerDto) {
        try {
            OwnerDto updatedOwner = ownerService.updateOwner(id, ownerDto);
            String message = "Owner with ID: " + id + " was successfully updated.";
            return ResponseEntity.ok(message);
        } catch (ResourceNotFoundException ex) {
            String errorMessage = "Owner with ID: " + id + " cannot be updated because it does not exist.";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        }
    }


    // Delete an owner
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteOwner(@PathVariable Long id) {
        try {
            ownerService.deleteOwner(id);
            return ResponseEntity.ok("Owner with ID: " + id + " was successfully deleted.");
        } catch (ResourceNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Owner with ID: " + id + " has already been deleted or does not exist.");
        }
    }


    // List properties for a specific owner
    @GetMapping("/{id}/properties")
    public ResponseEntity<List<Property>> listProperties(@PathVariable Long id) {
        List<Property> properties = ownerService.listProperties(id);
        return ResponseEntity.ok(properties);
    }



}
