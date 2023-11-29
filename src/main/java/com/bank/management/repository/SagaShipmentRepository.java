package com.bank.management.repository;

import com.bank.management.entity.SagaShipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SagaShipmentRepository extends JpaRepository<SagaShipment, Long> {


}
