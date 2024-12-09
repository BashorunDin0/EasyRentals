package com.olawale.dev.EasyRentals.Repositories;

import com.olawale.dev.EasyRentals.Entities.Tenant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TenantRepository extends JpaRepository<Tenant, Long> {
}
