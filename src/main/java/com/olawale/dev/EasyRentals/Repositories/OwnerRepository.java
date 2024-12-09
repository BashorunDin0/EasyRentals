package com.olawale.dev.EasyRentals.Repositories;

import com.olawale.dev.EasyRentals.Entities.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerRepository extends JpaRepository<Owner, Long> {
}
