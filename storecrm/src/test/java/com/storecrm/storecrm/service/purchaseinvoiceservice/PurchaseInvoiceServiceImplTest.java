package com.storecrm.storecrm.service.purchaseinvoiceservice;

import com.storecrm.storecrm.dto.purchaseinvoice.PurchaseInvoiceDTO;
import com.storecrm.storecrm.dto.purchaseinvoice.PurchaseInvoiceDTO.Create;
import com.storecrm.storecrm.dto.purchaseinvoice.PurchaseInvoiceDTO.Update;
import com.storecrm.storecrm.exception.EntityNotFoundException;
import com.storecrm.storecrm.model.purchaseinvoice.PurchaseInvoice;
import com.storecrm.storecrm.model.supplier.Supplier;
import com.storecrm.storecrm.model.user.User;
import com.storecrm.storecrm.repository.purchaseinvoice.PurchaseInvoiceRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PurchaseInvoiceServiceImplTest {

    @Mock
    private PurchaseInvoiceRepository repository;

    @InjectMocks
    private PurchaseInvoiceServiceImpl service;

    private PurchaseInvoice mockInvoice;
    private PurchaseInvoiceDTO mockInvoiceDTO;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        // Mocked PurchaseInvoice
        mockInvoice = PurchaseInvoice.builder()
                .id(1L)
                .date(Timestamp.valueOf(LocalDateTime.now()))
                .supplier(Supplier.builder().id(1L).build())
                .totalAmount(100.0)
                .status("Paid")
                .createdBy(User.builder().id(1L).build())
                .build();

        // Mocked PurchaseInvoiceDTO
        mockInvoiceDTO = new PurchaseInvoiceDTO(
                1L,
                mockInvoice.getDate().toLocalDateTime(),
                mockInvoice.getSupplier().getId(),
                BigDecimal.valueOf(mockInvoice.getTotalAmount()),
                mockInvoice.getStatus(),
                mockInvoice.getCreatedBy().getId()
        );
    }

    @Test
    void getAllInvoices_shouldReturnInvoiceList() {
        when(repository.findAll()).thenReturn(List.of(mockInvoice));

        List<PurchaseInvoiceDTO> result = service.getAllInvoices();

        assertEquals(1, result.size());
        assertEquals(mockInvoiceDTO.getId(), result.get(0).getId());
        verify(repository, times(1)).findAll();
    }

    @Test
    void getInvoiceById_shouldReturnInvoice() {
        when(repository.findById(1L)).thenReturn(Optional.of(mockInvoice));

        PurchaseInvoiceDTO result = service.getInvoiceById(1L);

        assertNotNull(result);
        assertEquals(mockInvoiceDTO.getId(), result.getId());
        verify(repository, times(1)).findById(1L);
    }

    @Test
    void getInvoiceById_shouldThrowEntityNotFoundException() {
        when(repository.findById(1L)).thenReturn(Optional.empty());

        EntityNotFoundException exception = assertThrows(EntityNotFoundException.class, () -> service.getInvoiceById(1L));

        assertEquals("Purchase invoice not found with ID: 1", exception.getMessage());
        verify(repository, times(1)).findById(1L);
    }

    @Test
    void createInvoice_shouldSaveAndReturnInvoice() {
        Create dto = new Create(
                mockInvoice.getDate().toLocalDateTime(),
                mockInvoice.getSupplier().getId(),
                BigDecimal.valueOf(mockInvoice.getTotalAmount()),
                mockInvoice.getStatus(),
                mockInvoice.getCreatedBy().getId()
        );

        when(repository.save(any(PurchaseInvoice.class))).thenReturn(mockInvoice);

        PurchaseInvoiceDTO result = service.createInvoice(dto);

        assertNotNull(result);
        assertEquals(mockInvoiceDTO.getId(), result.getId());
        ArgumentCaptor<PurchaseInvoice> captor = ArgumentCaptor.forClass(PurchaseInvoice.class);
        verify(repository, times(1)).save(captor.capture());

        PurchaseInvoice savedInvoice = captor.getValue();
        assertEquals(dto.getTotalAmount().doubleValue(), savedInvoice.getTotalAmount());
        assertEquals(dto.getSupplierId(), savedInvoice.getSupplier().getId());
    }

    @Test
    void updateInvoice_shouldUpdateAndReturnInvoice() {
        Update dto = new Update(
                mockInvoice.getDate().toLocalDateTime(),
                mockInvoice.getSupplier().getId(),
                BigDecimal.valueOf(200.0), // Updated amount
                "Unpaid",
                mockInvoice.getCreatedBy().getId()
        );

        when(repository.findById(1L)).thenReturn(Optional.of(mockInvoice));
        when(repository.save(any(PurchaseInvoice.class))).thenReturn(mockInvoice);

        PurchaseInvoiceDTO result = service.updateInvoice(1L, dto);

        assertNotNull(result);
        assertEquals("Unpaid", result.getStatus());
        assertEquals(200.0, result.getTotalAmount().doubleValue());
        verify(repository, times(1)).findById(1L);
        verify(repository, times(1)).save(mockInvoice);
    }

    @Test
    void updateInvoice_shouldThrowEntityNotFoundException() {
        Update dto = new Update(
                mockInvoice.getDate().toLocalDateTime(),
                mockInvoice.getSupplier().getId(),
                BigDecimal.valueOf(200.0),
                "Unpaid",
                mockInvoice.getCreatedBy().getId()
        );

        when(repository.findById(1L)).thenReturn(Optional.empty());

        EntityNotFoundException exception = assertThrows(EntityNotFoundException.class, () -> service.updateInvoice(1L, dto));

        assertEquals("Purchase invoice not found with ID: 1", exception.getMessage());
        verify(repository, times(1)).findById(1L);
    }

    @Test
    void deleteInvoice_shouldDeleteInvoice() {
        when(repository.existsById(1L)).thenReturn(true);

        service.deleteInvoice(1L);

        verify(repository, times(1)).deleteById(1L);
    }

    @Test
    void deleteInvoice_shouldThrowEntityNotFoundException() {
        when(repository.existsById(1L)).thenReturn(false);

        EntityNotFoundException exception = assertThrows(EntityNotFoundException.class, () -> service.deleteInvoice(1L));

        assertEquals("Purchase invoice not found with ID: 1", exception.getMessage());
        verify(repository, times(1)).existsById(1L);
    }
}
