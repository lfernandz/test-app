package com.test.wastemanagerservice.mapper;

import com.test.wastemanagerservice.dto.WasteCenterAuthorizationDto;
import com.test.wastemanagerservice.entities.WasteCenterAuthorizationEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface WasteCenterAuthorizationMapper {

    WasteCenterAuthorizationMapper INSTANCE = Mappers.getMapper(WasteCenterAuthorizationMapper.class);

    WasteCenterAuthorizationDto toWasteCenterAuthorizationDto(WasteCenterAuthorizationEntity entity);

    WasteCenterAuthorizationEntity toWasteCenterAuthorizationEntity(WasteCenterAuthorizationDto dto);

    List<WasteCenterAuthorizationDto> toWasteCenterAuthorizationDto(List<WasteCenterAuthorizationEntity> entity);

    List<WasteCenterAuthorizationEntity> toWasteCenterAuthorizationEntity(List<WasteCenterAuthorizationDto> dto);

}
