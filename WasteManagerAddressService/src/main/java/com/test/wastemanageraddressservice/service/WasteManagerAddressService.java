package com.test.wastemanageraddressservice.service;

import com.test.wastemanageraddressservice.dto.WasteManagerAddressDto;

import java.util.List;

public interface WasteManagerAddressService {

    WasteManagerAddressDto create(WasteManagerAddressDto wasteManagerAddressDto);

    WasteManagerAddressDto update(WasteManagerAddressDto wasteManagerAddressDto);

    String delete(Long id);

    WasteManagerAddressDto findById(Long id);

    List<WasteManagerAddressDto> findAll();

}
