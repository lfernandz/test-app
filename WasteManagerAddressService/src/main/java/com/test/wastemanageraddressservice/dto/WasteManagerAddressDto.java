package com.test.wastemanageraddressservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class WasteManagerAddressDto {

    private Long id;

    private String direccion;

    private Boolean isEnabled = Boolean.TRUE;

    private Long version = 0L;

    private Date createdDate;

    private Date lastModifiedDate;
}