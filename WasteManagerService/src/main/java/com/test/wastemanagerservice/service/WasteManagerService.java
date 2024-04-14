package com.test.wastemanagerservice.service;

import com.test.wastemanagerservice.dto.WasteManagerDto;

public interface WasteManagerService {

    WasteManagerDto create(WasteManagerDto wasteManagerDto);

    WasteManagerDto update(WasteManagerDto wasteManagerDto);

    WasteManagerDto findById(long wasteManagerId);
}