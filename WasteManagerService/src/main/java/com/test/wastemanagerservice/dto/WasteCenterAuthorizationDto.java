package com.test.wastemanagerservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class WasteCenterAuthorizationDto {

    private Long id;
    private String authorizationNumber;

}