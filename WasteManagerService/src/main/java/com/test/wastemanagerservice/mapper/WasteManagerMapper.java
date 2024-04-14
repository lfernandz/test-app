package com.test.wastemanagerservice.mapper;

import com.test.wastemanagerservice.dto.WasteManagerDto;
import com.test.wastemanagerservice.entities.WasteManagerEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface WasteManagerMapper {

    WasteManagerMapper INSTANCE = Mappers.getMapper(WasteManagerMapper.class);

    @Mapping(target = "listOfWasteCenterAuthorization", ignore = true)
    @Mapping(target = "wasteManagerAddressDto", ignore = true)
    WasteManagerDto toWasteManagerDto(WasteManagerEntity entity);

    @Mapping(target = "listOfWasteCenterAuthorization", ignore = true)
    @Mapping(target = "wasteManagerAddressEntity", ignore = true)
    WasteManagerEntity toWasteManagerEntity(WasteManagerDto dto);

}