package com.test.wastemanageraddressservice.repository;

import com.test.wastemanageraddressservice.entities.WasteManagerAddressEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WasteManagerAddressRepository extends JpaRepository<WasteManagerAddressEntity, Long> {
}
