package com.test.wastemanageraddressservice.controller;

import com.test.wastemanageraddressservice.dto.WasteManagerAddressDto;
import com.test.wastemanageraddressservice.service.WasteManagerAddressService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/waste-manager-address")
public class WasteManagerAddressController {

    private final WasteManagerAddressService service;

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody WasteManagerAddressDto managerAddressDto) {
        return new ResponseEntity<>(service.create(managerAddressDto), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody WasteManagerAddressDto managerAddressDto){
        return ResponseEntity.ok(service.update(managerAddressDto));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        return ResponseEntity.ok(service.delete(id));
    }

    @GetMapping("/find-all")
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/find-by-id/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        return ResponseEntity.ok(service.findById(id));
    }

}
