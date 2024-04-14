package com.test.wastemanagerservice.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "waste_manager_address")
public class WasteManagerAddressEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String direccion;

    @Column(name = "is_enabled")
    private Boolean isEnabled = Boolean.TRUE;

    private Long version = 0L;

    @Column(name = "created_date", columnDefinition = "DATE")
    private Date createdDate;

    @Column(name = "last_modified_date", columnDefinition = "DATE")
    private Date lastModifiedDate;

}