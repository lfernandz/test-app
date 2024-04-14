package com.test.wastemanageraddressservice.mapper;

import com.test.wastemanageraddressservice.dto.WasteManagerAddressDto;
import com.test.wastemanageraddressservice.entities.WasteManagerAddressEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface WasteManagerAddressMapper {

    WasteManagerAddressMapper INSTANCE = Mappers.getMapper(WasteManagerAddressMapper.class);

    WasteManagerAddressDto toWasteManagerAddressDto(WasteManagerAddressEntity entity);

    WasteManagerAddressEntity toWasteManagerAddressEntity(WasteManagerAddressDto dto);

    List<WasteManagerAddressDto> toWasteManagerAddressDto(List<WasteManagerAddressEntity> entities);

}
