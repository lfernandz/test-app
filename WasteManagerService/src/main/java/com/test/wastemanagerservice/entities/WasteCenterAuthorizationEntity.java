package com.test.wastemanagerservice.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "waste_center_authorization")
public class WasteCenterAuthorizationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "authorization_number")
    private String authorizationNumber;

    @ManyToOne(targetEntity = WasteManagerEntity.class)
    @JoinColumn(name = "waste_manager_id")
    private WasteManagerEntity wasteManagerEntity;

}
