package com.olawale.dev.EasyRentals.Repositories;

import com.olawale.dev.EasyRentals.Entities.Property;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Properties;

public interface PropertyRepository extends JpaRepository<Property, Long> {
    List<Property> findByAddressAndRentAndNumberOfRooms(String address, Double rent, Integer numberOfRooms);

    List<Property> findByAddressContainingAndRentLessThanEqualAndNumberOfRooms(String address, Double rent, Integer numberOfRooms);
}
