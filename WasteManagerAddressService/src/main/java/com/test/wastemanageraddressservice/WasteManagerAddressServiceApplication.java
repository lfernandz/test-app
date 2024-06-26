package com.test.wastemanageraddressservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class WasteManagerAddressServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(WasteManagerAddressServiceApplication.class, args);
    }

}
