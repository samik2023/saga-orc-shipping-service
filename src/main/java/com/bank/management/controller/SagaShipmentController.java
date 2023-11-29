package com.bank.management.controller;

import com.bank.management.service.SagaShipmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Slf4j
@RestController
@RequestMapping("/api/shipments")
public class SagaShipmentController {

    @Autowired
    SagaShipmentService service;

    @PostMapping(value = "/startShipping",
            produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<String> startShipping(@RequestBody Long orderId) {

        service.startShipment(orderId);
        return new ResponseEntity<>("Shipment started", HttpStatus.OK);
    }
}
