package com.bank.management;

import com.bank.management.entity.SagaShipment;
import com.bank.management.repository.SagaShipmentRepository;
import com.bank.management.service.SagaShipmentService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class OrderServiceTest {

    @Mock
    private SagaShipmentRepository orderRepository;

    @InjectMocks
    private SagaShipmentService orderService = new SagaShipmentService();

    @BeforeEach
    void setMockData() {
        List<SagaShipment> mockOrders = new ArrayList<>();
        mockOrders.add(new SagaShipment());
        when(orderRepository.findAll()).thenReturn(mockOrders);
    }

    @DisplayName("Test orderService and repository")
    @Test
    void testGetAllOrders() {
        assertEquals(1, orderService.getAllOrders().size());
    }
}
