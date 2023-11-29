package com.bank.management;

import com.bank.management.repository.SagaShipmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@Slf4j
@SpringBootApplication
@EnableFeignClients
public class SagaShipmentServiceApplication {

    @Autowired
    private SagaShipmentRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(SagaShipmentServiceApplication.class, args);
    }

}
