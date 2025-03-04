package com.storecrm.storecrm.service.supplierservice;

import com.storecrm.storecrm.dto.supplier.SupplierDTO;
import com.storecrm.storecrm.mapper.supplier.SupplierMapper;
import com.storecrm.storecrm.model.supplier.Supplier;
import com.storecrm.storecrm.repository.supplier.SupplierRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class SupplierServiceImplTest {

    @Mock
    private SupplierRepository supplierRepository;

    @Mock
    private SupplierMapper supplierMapper;

    @InjectMocks
    private SupplierServiceImpl supplierService;

    private Supplier mockSupplier;
    private SupplierDTO.SupplierResponse mockSupplierResponse;

    @BeforeEach
    void setUp() {
        mockSupplier = new Supplier();
        mockSupplier.setId(1L);
        mockSupplier.setName("Test Sup");
        mockSupplier.setEmail("test@Sup.com");

        mockSupplierResponse = new SupplierDTO.SupplierResponse();
        mockSupplierResponse.setId(1L);
        mockSupplierResponse.setName("Test Sup");
        mockSupplierResponse.setEmail("test@Sup.com");
    }

    @Test
    void getSupplierById_shouldReturnSupplierResponse_whenSupplierExists() {

        when(supplierRepository.findById(1L)).thenReturn(Optional.of(mockSupplier));
        when(supplierMapper.toResponseDTO(mockSupplier)).thenReturn(mockSupplierResponse);


        SupplierDTO.SupplierResponse result = supplierService.getSupplierById(1L);

        assertEquals(mockSupplierResponse, result);
    }
}
