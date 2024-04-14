package com.test.wastemanagerservice.service.impl;

import com.test.wastemanagerservice.client.WasteManagerAddressClient;
import com.test.wastemanagerservice.dto.WasteCenterAuthorizationDto;
import com.test.wastemanagerservice.dto.WasteManagerAddressDto;
import com.test.wastemanagerservice.dto.WasteManagerDto;
import com.test.wastemanagerservice.entities.WasteCenterAuthorizationEntity;
import com.test.wastemanagerservice.entities.WasteManagerEntity;
import com.test.wastemanagerservice.exceptions.CreateException;
import com.test.wastemanagerservice.exceptions.NoValueException;
import com.test.wastemanagerservice.mapper.WasteCenterAuthorizationMapper;
import com.test.wastemanagerservice.mapper.WasteManagerMapper;
import com.test.wastemanagerservice.repository.WasteCenterAuthorizationRepository;
import com.test.wastemanagerservice.repository.WasteManagerRepository;
import com.test.wastemanagerservice.service.WasteManagerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@Service
public class WasteManagerServiceImpl implements WasteManagerService {

    private final WasteManagerRepository repository;
    private final WasteCenterAuthorizationRepository authorizationRepository;
    private final WasteManagerAddressClient managerAddressClient;

    @Override
    public WasteManagerDto create(WasteManagerDto wasteManagerDto) {
        try {
            WasteManagerEntity entity = WasteManagerMapper.INSTANCE.toWasteManagerEntity(wasteManagerDto);
            List<WasteCenterAuthorizationEntity> centerAuthorizationEntities =
                    WasteCenterAuthorizationMapper.INSTANCE.toWasteCenterAuthorizationEntity(wasteManagerDto.getListOfWasteCenterAuthorization());

            centerAuthorizationEntities = authorizationRepository.saveAll(centerAuthorizationEntities);

            entity.setCreatedDate(new Date());
            entity.setLastModifiedDate(new Date());

            /* Creando en microservicio WasteManagerAddress */
            WasteManagerAddressDto addressDto =
                    managerAddressClient.create(wasteManagerDto.getWasteManagerAddressDto());

            repository.save(entity);

            WasteManagerDto wasteManagerDtoResult = WasteManagerMapper.INSTANCE.toWasteManagerDto(entity);
            List<WasteCenterAuthorizationDto> centerAuthorizationDto = WasteCenterAuthorizationMapper.INSTANCE.toWasteCenterAuthorizationDto(centerAuthorizationEntities);

            wasteManagerDtoResult.setWasteManagerAddressDto(addressDto);
            wasteManagerDtoResult.setListOfWasteCenterAuthorization(centerAuthorizationDto);

            return wasteManagerDtoResult;
        } catch (CreateException e){
            throw new CreateException("Error creating new Waste Manager");
        }
    }

    @Override
    public WasteManagerDto update(WasteManagerDto wasteManagerDto) {
        try {
            WasteManagerEntity entity = repository.findById(wasteManagerDto.getId())
                    .orElseThrow(() -> new NoValueException("Waste Manager with id " + wasteManagerDto.getId() + " not found"));

            if (entity.getIsEnabled() != wasteManagerDto.getIsEnabled())
                entity.setIsEnabled(wasteManagerDto.getIsEnabled());
            if (!entity.getNif().equals(wasteManagerDto.getNif()))
                entity.setNif(wasteManagerDto.getNif());
            if (!entity.getNombre().equals(wasteManagerDto.getNombre()))
                entity.setNombre(wasteManagerDto.getNombre());
            if (!entity.getVersion().equals(wasteManagerDto.getVersion()))
                entity.setVersion(wasteManagerDto.getVersion());

            List<WasteCenterAuthorizationEntity> centerAuthorizationEntities =
                    WasteCenterAuthorizationMapper.INSTANCE.toWasteCenterAuthorizationEntity(wasteManagerDto.getListOfWasteCenterAuthorization());
            centerAuthorizationEntities = authorizationRepository.saveAll(centerAuthorizationEntities);

            entity.setListOfWasteCenterAuthorization(centerAuthorizationEntities);
            entity.setLastModifiedDate(new Date());

            /* Actualizando en microservicio WasteManagerAddress */
            WasteManagerAddressDto addressDto =
                    managerAddressClient.update(wasteManagerDto.getWasteManagerAddressDto());

            repository.save(entity);

            WasteManagerDto result = WasteManagerMapper.INSTANCE.toWasteManagerDto(entity);
            List<WasteCenterAuthorizationDto> centerAuthorizationDto = WasteCenterAuthorizationMapper.INSTANCE.toWasteCenterAuthorizationDto(centerAuthorizationEntities);
            result.setWasteManagerAddressDto(addressDto);
            result.setListOfWasteCenterAuthorization(centerAuthorizationDto);

            return result;
        } catch (CreateException e){
            throw new CreateException("Error updating Waste Manager");
        }
    }

    @Override
    public WasteManagerDto findById(long wasteManagerId) {
        WasteManagerEntity entity = repository.findById(wasteManagerId)
                .orElseThrow(() -> new NoValueException("Waste Manager with id " + wasteManagerId + " not found"));

        List<WasteCenterAuthorizationEntity> list = entity.getListOfWasteCenterAuthorization();

        WasteManagerDto wasteManagerDto = WasteManagerMapper.INSTANCE.toWasteManagerDto(entity);

        List<WasteCenterAuthorizationDto> listDto =
                WasteCenterAuthorizationMapper.INSTANCE.toWasteCenterAuthorizationDto(list);

        wasteManagerDto.setListOfWasteCenterAuthorization(listDto);

        /* Consultando al microservicio WasteManagerAddress */
        WasteManagerAddressDto addressDto =
                managerAddressClient.findByWasteManagerAddressId(entity.getWasteManagerAddressEntity().getId());

        wasteManagerDto.setWasteManagerAddressDto(addressDto);
        return wasteManagerDto;
    }
}
