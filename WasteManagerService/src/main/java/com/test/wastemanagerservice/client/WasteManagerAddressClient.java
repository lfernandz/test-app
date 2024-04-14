package com.test.wastemanagerservice.client;

import com.test.wastemanagerservice.dto.WasteManagerAddressDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "WasteManagerAddressService", url = "localhost:8080/waste-manager-address")
public interface WasteManagerAddressClient {

    @GetMapping(value = "/find-by-id/{id}", consumes = "application/json")
    WasteManagerAddressDto findByWasteManagerAddressId(@PathVariable Long id);

    @PostMapping(value = "/create", consumes = "application/json")
    WasteManagerAddressDto create(@RequestBody WasteManagerAddressDto wasteManagerAddressDto);

    @PutMapping(value = "/update", consumes = "application/json")
    WasteManagerAddressDto update(@RequestBody WasteManagerAddressDto managerAddressDto);
}
