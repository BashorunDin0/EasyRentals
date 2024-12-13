package com.olawale.dev.EasyRentals.Controllers;

import com.olawale.dev.EasyRentals.Dtos.PropertyDto;
import com.olawale.dev.EasyRentals.Services.PropertyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/properties")
public class PropertyController {
    private final PropertyService propertyService;

    public PropertyController(PropertyService propertyService) {
        this.propertyService = propertyService;
    }

    @PostMapping
    public ResponseEntity<String> addProperty(@RequestBody PropertyDto propertyDto) {
        PropertyDto addedProperty = propertyService.addProperty(propertyDto);
        String message = "Property with ID: " + addedProperty.getId() + " was successfully added.";
        return ResponseEntity.status(HttpStatus.CREATED).body(message);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PropertyDto> getPropertyById(@PathVariable Long id) {
        PropertyDto propertyDto = propertyService.getPropertyById(id);
        return ResponseEntity.ok(propertyDto);
    }

    @GetMapping
    public ResponseEntity<List<PropertyDto>> getAllProperties() {
        List<PropertyDto> properties = propertyService.getAllProperties();
        return ResponseEntity.ok(properties);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateProperty(@PathVariable Long id, @RequestBody PropertyDto propertyDto) {
        try {
            PropertyDto updatedProperty = propertyService.updateProperty(id, propertyDto);
            String message = "Property with ID: " + id + " was successfully updated.";
            return ResponseEntity.ok(message);
        } catch (Exception ex) {
            String errorMessage = "Property with ID: " + id + " cannot be updated because it does not exist.";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProperty(@PathVariable Long id) {
        try {
            propertyService.deleteProperty(id);
            String message = "Property with ID: " + id + " was successfully deleted.";
            return ResponseEntity.ok(message);
        } catch (Exception ex) {
            String errorMessage = "Property with ID: " + id + " cannot be deleted because it does not exist.";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);
        }
    }

    @GetMapping("/search")
    public ResponseEntity<List<PropertyDto>> searchProperties(
            @RequestParam(required = false) String address,
            @RequestParam(required = false) Double rent,
            @RequestParam(required = false) Integer numberOfRooms) {
        List<PropertyDto> properties = propertyService.searchProperties(address, rent, numberOfRooms);
        return ResponseEntity.ok(properties);

    }
}
