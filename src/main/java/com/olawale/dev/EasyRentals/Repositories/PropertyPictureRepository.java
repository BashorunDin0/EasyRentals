package com.olawale.dev.EasyRentals.Repositories;

import com.olawale.dev.EasyRentals.Entities.PropertyPicture;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PropertyPictureRepository extends JpaRepository<PropertyPicture, Long> {
    List<PropertyPicture> findByPropertyId(Long propertyId);
}
