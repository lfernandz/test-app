package com.test.wastemanagerservice.repository;

import com.test.wastemanagerservice.entities.WasteManagerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WasteManagerRepository extends JpaRepository<WasteManagerEntity, Long> {
}
