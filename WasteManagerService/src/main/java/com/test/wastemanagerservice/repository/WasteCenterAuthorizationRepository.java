package com.test.wastemanagerservice.repository;

import com.test.wastemanagerservice.entities.WasteCenterAuthorizationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WasteCenterAuthorizationRepository extends JpaRepository<WasteCenterAuthorizationEntity, Long> {
}
