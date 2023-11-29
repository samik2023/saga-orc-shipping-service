package com.bank.management.service;

import com.bank.management.entity.Event;
import com.bank.management.entity.SagaShipment;
import com.bank.management.entity.ShipmentStatus;
import com.bank.management.messaging.SagaShipmentEventProducer;
import com.bank.management.repository.SagaShipmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SagaShipmentService {

    @Autowired
    private SagaShipmentRepository repository;

    @Autowired
    private SagaShipmentEventProducer producer;

    public void startShipment(Long orderId) {

        try {
            //simulating failure rollback
            if (orderId == 1)
                throw new RuntimeException();

            SagaShipment shipment = new SagaShipment();
            shipment.setOrderId(orderId);
            shipment.setStatus(ShipmentStatus.IN_TRANSIT);
            SagaShipment p = repository.save(shipment);
            Event event = new Event();
            event.setPhase("Shipment");
            event.setOrderId(orderId);
            event.setEventStatus("SUCCESS");
            producer.createEvent(event);
        } catch (Exception e) {
            e.getMessage();
            Event event = new Event();
            event.setPhase("Shipment");
            event.setOrderId(orderId);
            event.setEventStatus("FAILURE");
            producer.createEvent(event);
        }
    }

   /* public void processPayment(Event event){

        if("INITIATE_PAYMENT".equalsIgnoreCase(event.getEventType()) &&
                "CREDIT".equalsIgnoreCase(event.getPaymentType())) {
            SagaPayment payment = new SagaPayment();
            payment.setOrderId(event.getOrderId());
            payment.setStatus(PaymentStatus.COMPLETED);
            repository.save(payment);
            Event event2 = new Event(event.getOrderId(),"SUCCESS","");
            //event2.setEventType("SUCCESS");
            //event2.setPaymentType("");
            producer.createSuccessEvent(event2);
        }else if("INITIATE_PAYMENT".equalsIgnoreCase(event.getEventType())&&
             "COD".equalsIgnoreCase(event.getPaymentType())) {
            SagaPayment payment = new SagaPayment();
            payment.setOrderId(event.getOrderId());
            payment.setStatus(PaymentStatus.PENDING);
            repository.save(payment);
            Event event2 = new Event(event.getOrderId(),"SUCCESS","");
            //event2.setEventType("SUCCESS");
            //event2.setPaymentType("");
            producer.createSuccessEvent(event2);
        }
        else{
            SagaPayment payment = new SagaPayment();
            payment.setOrderId(event.getOrderId());
            payment.setStatus(PaymentStatus.FAILED);
            repository.save(payment);
            Event event2 = new Event(event.getOrderId(),"FAILURE","");
            //event2.setEventType("FAILURE");
            //event2.setPaymentType("");
            producer.createFailureEvent(event2);
        }
    }*/
}