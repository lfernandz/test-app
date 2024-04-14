package com.test.wastemanagerservice.controller;

import com.test.wastemanagerservice.dto.WasteManagerDto;
import com.test.wastemanagerservice.service.WasteManagerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/waste-manager")
public class WasteManagerController {

    private final WasteManagerService service;

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody WasteManagerDto wasteManagerDto){
        return new ResponseEntity<>(service.create(wasteManagerDto), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<?> update(@RequestBody WasteManagerDto wasteManagerDto){
        return ResponseEntity.ok(service.update(wasteManagerDto));
    }

    @GetMapping("/find-by-id/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id){
        return ResponseEntity.ok(service.findById(id));
    }

}
