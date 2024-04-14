package com.test.wastemanagerservice.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "waste_manager")
public class WasteManagerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    private String nif;

    @Column(name = "is_enabled")
    private Boolean isEnabled = Boolean.TRUE;

    private Long version = 0L;

    @Column(name = "created_date", columnDefinition = "DATE")
    private Date createdDate;

    @Column(name = "last_modified_date", columnDefinition = "DATE")
    private Date lastModifiedDate;

    @OneToOne(targetEntity = WasteManagerAddressEntity.class, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "waste_manager_address_id", referencedColumnName = "id")
    private WasteManagerAddressEntity wasteManagerAddressEntity;

    @OneToMany(targetEntity = WasteCenterAuthorizationEntity.class, fetch = FetchType.EAGER, mappedBy = "wasteManagerEntity")
    private List<WasteCenterAuthorizationEntity>
            listOfWasteCenterAuthorization = new ArrayList<>();
}