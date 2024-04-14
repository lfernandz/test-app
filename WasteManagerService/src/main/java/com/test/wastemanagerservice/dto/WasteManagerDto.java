package com.test.wastemanagerservice.dto;

import com.test.wastemanagerservice.entities.WasteCenterAuthorizationEntity;
import com.test.wastemanagerservice.entities.WasteManagerAddressEntity;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WasteManagerDto {

    private Long id;

    private String nombre;

    private String nif;

    private Boolean isEnabled = Boolean.TRUE;

    private Long version = 0L;

    private Date createdDate;

    private Date lastModifiedDate;

    private WasteManagerAddressDto wasteManagerAddressDto;

    private List<WasteCenterAuthorizationDto> listOfWasteCenterAuthorization;

}
