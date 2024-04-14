package com.test.wastemanageraddressservice.service.impl;

import com.test.wastemanageraddressservice.dto.WasteManagerAddressDto;
import com.test.wastemanageraddressservice.entities.WasteManagerAddressEntity;
import com.test.wastemanageraddressservice.exceptions.CreateException;
import com.test.wastemanageraddressservice.exceptions.NoValueException;
import com.test.wastemanageraddressservice.mapper.WasteManagerAddressMapper;
import com.test.wastemanageraddressservice.repository.WasteManagerAddressRepository;
import com.test.wastemanageraddressservice.service.WasteManagerAddressService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class WasteManagerAddressImpl implements WasteManagerAddressService {

    private final WasteManagerAddressRepository repository;

    @Override
    public WasteManagerAddressDto create(WasteManagerAddressDto wasteManagerAddressDto) {
        try {
            WasteManagerAddressEntity entity =
                    WasteManagerAddressMapper.INSTANCE.toWasteManagerAddressEntity(wasteManagerAddressDto);
            entity.setCreatedDate(new Date());
            entity.setLastModifiedDate(new Date());
            entity = repository.save(entity);
            return WasteManagerAddressMapper.INSTANCE.toWasteManagerAddressDto(entity);
        } catch (CreateException e){
            throw new CreateException("Error creating new Waste Manager Address");
        }
    }

    @Override
    public WasteManagerAddressDto update(WasteManagerAddressDto wasteManagerAddressDto) {
        try {

            WasteManagerAddressEntity entity = repository.findById(wasteManagerAddressDto.getId())
                    .orElseThrow(() -> new NoValueException("Waste Manager Address with id " + wasteManagerAddressDto.getId() + " not found"));
            if (entity.getIsEnabled() != wasteManagerAddressDto.getIsEnabled())
                entity.setIsEnabled(wasteManagerAddressDto.getIsEnabled());
            if (!entity.getDireccion().equals(wasteManagerAddressDto.getDireccion()))
                entity.setDireccion(wasteManagerAddressDto.getDireccion());
            if (!entity.getVersion().equals(wasteManagerAddressDto.getVersion()))
                entity.setVersion(wasteManagerAddressDto.getVersion());
            entity.setLastModifiedDate(new Date());

            entity = repository.save(entity);

            return WasteManagerAddressMapper.INSTANCE.toWasteManagerAddressDto(entity);
        } catch (CreateException e){
            throw new CreateException("Error updating Waste Manager Address");
        }
    }

    @Override
    public String delete(Long id) {
        if(!repository.existsById(id))
            throw new NoValueException("Waste Manager Address with id " + id + " not found");

        repository.deleteById(id);

        return "Waste Manager Address has been deleted";
    }

    @Override
    public WasteManagerAddressDto findById(Long id){
        WasteManagerAddressEntity entity = repository.findById(id)
                .orElseThrow(() -> new NoValueException("Waste Manager Address with id " + id + " not found"));
        return WasteManagerAddressMapper.INSTANCE.toWasteManagerAddressDto(entity);
    }

    @Override
    public List<WasteManagerAddressDto> findAll() {
        List<WasteManagerAddressEntity> entities = repository.findAll();
        return WasteManagerAddressMapper.INSTANCE.toWasteManagerAddressDto(entities);
    }
}
