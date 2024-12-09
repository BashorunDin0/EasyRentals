package com.olawale.dev.EasyRentals.Controllers;

import com.olawale.dev.EasyRentals.Dtos.PropertyPictureDto;
import com.olawale.dev.EasyRentals.Services.PropertyPictureService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/property-pictures")
public class PropertyPictureController {

    private final PropertyPictureService propertyPictureService;

    public PropertyPictureController(PropertyPictureService propertyPictureService) {
        this.propertyPictureService = propertyPictureService;
    }

    // Add a picture to a property
    @PostMapping("/{propertyId}")
    public ResponseEntity<PropertyPictureDto> addPropertyPicture(
            @PathVariable Long propertyId,
            @RequestBody PropertyPictureDto propertyPictureDto) {
        PropertyPictureDto addedPicture = propertyPictureService.addPropertyPicture(propertyPictureDto, propertyId);
        return ResponseEntity.status(HttpStatus.CREATED).body(addedPicture);
    }

    // Update a property picture
    @PutMapping("/{pictureId}")
    public ResponseEntity<PropertyPictureDto> updatePropertyPicture(
            @PathVariable Long pictureId,
            @RequestBody PropertyPictureDto propertyPictureDto) {
        PropertyPictureDto updatedPicture = propertyPictureService.updatePropertyPicture(pictureId, propertyPictureDto);
        return ResponseEntity.ok(updatedPicture);
    }

    // Delete a property picture
    @DeleteMapping("/{pictureId}")
    public ResponseEntity<String> deletePropertyPicture(@PathVariable Long pictureId) {
        propertyPictureService.deletePropertyPicture(pictureId);
        String message = "Property picture with ID: " + pictureId + " was successfully deleted.";
        return ResponseEntity.ok(message);
    }

    // Get all pictures for a property
    @GetMapping("/{propertyId}")
    public ResponseEntity<List<PropertyPictureDto>> getPropertyPictures(@PathVariable Long propertyId) {
        List<PropertyPictureDto> pictures = propertyPictureService.getPropertyPictures(propertyId);
        return ResponseEntity.ok(pictures);
    }
}
